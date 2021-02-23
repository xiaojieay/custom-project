package com.github.jay.custom.project.custom.service;

import com.github.jay.custom.project.custom.service.entity.FlightInfo;

import java.util.List;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/30 10:56 上午
 */
public interface FlightInfoService {

    /**
     * 保存航班信息
     *
     * @param flightInfo
     *            航班信息
     * @return 是否添加成功
     */
    boolean insertFlightInfo(FlightInfo flightInfo);

    /**
     * 获取所有的航班信息
     *
     * @return 航班信息集合
     */
    List<FlightInfo> flightInfos();
}
