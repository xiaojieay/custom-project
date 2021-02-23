package com.github.jay.custom.project.custom.service.aop;

import com.github.jay.custom.project.custom.dal.config.DynamicDataSourceContextHolder;
import com.github.jay.custom.project.custom.dal.enums.DataSourceEnum;
import com.github.jay.custom.project.custom.service.entity.FlightInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

/**
 * 数据源切换切面
 *
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/1 10:05 下午
 */
@Aspect
@EnableAspectJAutoProxy
@Component
@Order(1)
public class DataSourceSearchAop {

    @Pointcut(value = "execution(* com.github.jay.custom.project.custom.service.impl..*.*(..))")
    public void aopTarget() {

    }

    @Before(value = "aopTarget()")
    public void selectDataSource(JoinPoint joinPoint) {
        Optional<Object[]> paramList = Optional.ofNullable(joinPoint.getArgs()).filter(params -> params.length > 0);
        paramList.ifPresent(objects -> Arrays.stream(objects).forEach(param -> {
            if (param instanceof FlightInfo) {
                DynamicDataSourceContextHolder.setContextKey(Long.parseLong(((FlightInfo)param).getFlightNo()) % 2 == 0
                    ? DataSourceEnum.DRUID.getCode() : DataSourceEnum.HIKARICP.getCode());
            }
        }));
    }

    @After(value = "aopTarget()")
    public void removeDataSource() {
        DynamicDataSourceContextHolder.removeContextKey();
    }
}
