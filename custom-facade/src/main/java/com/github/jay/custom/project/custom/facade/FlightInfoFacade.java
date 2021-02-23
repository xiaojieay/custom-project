package com.github.jay.custom.project.custom.facade;


import com.github.jay.custom.project.custom.facade.response.FlightInfoResponse;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/3 10:39 下午
 */
public interface FlightInfoFacade {

    /**
     * 获取所有航班信息
     *
     * @return 航班响应信息
     */
    FlightInfoResponse getAllFlightInfo();

}
