package com.github.jay.custom.project.custom.dal.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.jay.custom.project.custom.dal.enums.DataSourceEnum;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库层面
 *
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/29 4:23 下午
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.github.jay.custom.project.custom.dal.dao")
public class DynamicDataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

    // -------------------------- druid数据源 --------------------------

    /*
     * druid数据源实现原理
     *
     *      1、初始化(ReentrantLock加锁保证只会初始化一次)
     *
     *            创建initial-size指定连接数放入连接池中
     *
     *            创建Connect-Create线程并启动[create线程会一直阻塞]
     *
     *            创建Connection-Destroy定时检测线程并启动[time-between-eviction-runs-millis指定间隔时间执行]
     *
     *      2、获取连接(生产者消费者模式，整个过程ReentrantLock加锁)
     *
     *            检测连接池是否已经初始化，未初始化执行初始化
     *
     *            连接池中存在连接直接获取使用
     *
     *            连接池中没有连接，唤醒Connection-Create线程创建新的连接，此时阻塞等待线程创建完成
     *
     *            如果此时连接池中的连接没有达到最大值，Connection-Create线程创建新的连接放入池中唤醒等待中的获取连接线程，如果达到最大值继续等待直到超时
     *
     *            Connection-Destroy线程同时检测是否满足配置的空闲连接需要回收
     */

    /**
     * 配置druid
     *
     * @return druid
     */
    @Primary
    @Bean(name = "customDruidDataSource")
    @Qualifier("customDruidDataSource")
    @ConfigurationProperties(value = "spring.datasource.druid")
    public DataSource druidDataSource() {

        return DruidDataSourceBuilder.create().build();
    }

    // -------------------------- hikaricp数据源 ------------------------

    /*
     * hikaricp数据源实现原理
     *
     *      1、初始化(双重校验锁单例模式创建，保证只初始化一次)
     *
     *            初始化DataSource
     *
     *            创建minimum-idle指定连接数放入连接池中
     *
     *            创建Connection-Add线程池[corePoolSize=1,maxPoolSize=1,blockingQueue=LinkedBlockingQueue,rejectedHandler=DiscardOldestPolicy(丢弃最新的请求)]
     *
     *            创建Connection-Close线程池[corePoolSize=1,maxPoolSize=1,blockingQueue=LinkedBlockingQueue,rejectedHandler=CallerRunsPolicy(当前线程执行任务)]
     *
     *            创建houseKeeperTask定时任务定时检测连接池中的空闲连接是否满足回收条件
     *
     *      2、获取连接(未加锁，通过CAS、阻塞队列、线程池(max线程为1)等技术)
     *
     *            从线程本地ThreadLocal中获取连接，存在直接返回连接
     *
     *            从共享连接集合中获取，如果当前等待获取连接线程大于1会通过Connection-Create线程池创建新的连接[内部会判断当前等待线程是否大于最大连接数，大于才会执行]
     *
     *            直接通过Connection-Create线程池创建新的连接，同时从阻塞队列中获取创建的新的连接或者已经被回收的连接[阻塞直到超时]
     *
     *            Connection-Create线程会根据连接池当前状态判断是否需要创建新的连接，不创建直接等待，创建完新的连接后会放入阻塞队列中直接可以唤醒等待的线程获取连接
     *
     *            houseKeeperTask定时任务定时检测连接池中的空闲连接是否满足回收条件
     */

    @Bean(name = "hikaricpDataSource")
    @Qualifier("hikaricpDataSource")
    @ConfigurationProperties(value = "spring.datasource.hikari")
    public DataSource hikaricpDataSource() {
        return new HikariDataSource();
    }

    // -------------------------- 程序动态运行数据源 --------------------------------

    /*
     * spring boot动态数据源实现原理
     *
     *     AbstractRoutingDataSource内部维护数据源标识key-数据源DataSource
     *
     *     每次调用数据源时通过获取当前指定的数据源标示key即可获取需要使用的数据源
     */

    /**
     * 配置动态数据源
     *
     * @param customDruidDataSource
     *            druid数据源
     * @return 自定义数据源
     */
    @Bean(name = "dynamicDataSource")
    @Qualifier("dynamicDataSource")
    public DataSource dynamicDataSource(@Qualifier("customDruidDataSource") DataSource customDruidDataSource,
        @Qualifier("hikaricpDataSource") DataSource hikaricpDataSource) {

        Map<Object, Object> dataSourceMap = new HashMap<>(8);
        dataSourceMap.put(DataSourceEnum.DRUID.getCode(), customDruidDataSource);
        dataSourceMap.put(DataSourceEnum.HIKARICP.getCode(), hikaricpDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(customDruidDataSource);
        return dynamicDataSource;
    }

    // ----------------------------- Mybatis SqlSessionFactory ------------------------------

    /*
     * spring boot-mybatis原理(整个调用过程)
     *
     *      1、MapperScan注解将dao接口加载到spring中变成BeanDefinition[class类型为MapperFactoryBean，一个dao接口对应一个MapperFactoryBean]
     *
     *      2、Spring容器初始化过程中会调用FactoryBean.getBean生成实例(MapperFactoryBean.getObject)
     *
     *      3、获取注册在Spring中的dao接口，通过JDK动态代理的方式为mapper接口生成代理类
     *
     *      4、调用dao的任何接口都会去调用代理类的invoke方法
     */

    /**
     * 配置动态SqlSessionFactory
     *
     * @param dynamicDataSource
     *            动态数据源
     * @return SqlSessionFactory
     */
    @Primary
    @Bean(name = "dynamicSqlSessionFactory")
    @Qualifier("dynamicSqlSessionFactory")
    public SqlSessionFactory dynamicSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        try {
            sqlSessionFactoryBean
                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
            sqlSessionFactoryBean.setTypeAliasesPackage("com.github.jay.custom.project.custom.dal.entity");
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("初始化SqlSessionFactory异常");
            throw new RuntimeException("初始化SqlSessionFactory发生错误" + e.getMessage());
        }
    }

    /**
     * 将事务交给Spring进行管理
     *
     * @param dynamicDataSource
     *            动态数据源
     * @return PlatformTransactionManager
     */
    @Bean(name = "dynamicDataSourceTransactionManager")
    @Qualifier("dynamicDataSourceTransactionManager")
    public PlatformTransactionManager
        dynamicDataSourceTransactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {

        return new DataSourceTransactionManager(dynamicDataSource);
    }

    /*
     * 思考
     *
     *      1、
     */

}