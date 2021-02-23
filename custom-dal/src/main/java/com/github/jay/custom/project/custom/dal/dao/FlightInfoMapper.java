package com.github.jay.custom.project.custom.dal.dao;

import com.github.jay.custom.project.custom.dal.entity.FlightInfoDO;
import com.github.jay.custom.project.custom.dal.entity.FlightInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/29 4:38 下午
 */
public interface FlightInfoMapper {

    int deleteByExample(FlightInfoDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlightInfoDO record);

    int insertSelective(FlightInfoDO record);

    List<FlightInfoDO> selectByExample(FlightInfoDOExample example);

    FlightInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlightInfoDO record, @Param("example") FlightInfoDOExample example);

    int updateByExample(@Param("record") FlightInfoDO record, @Param("example") FlightInfoDOExample example);

    int updateByPrimaryKeySelective(FlightInfoDO record);

    int updateByPrimaryKey(FlightInfoDO record);

    List<FlightInfoDO> selectAll();
}