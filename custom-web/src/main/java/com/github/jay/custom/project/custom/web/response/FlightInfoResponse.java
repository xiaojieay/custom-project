package com.github.jay.custom.project.custom.web.response;

import com.github.jay.custom.project.custom.service.entity.FlightInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 航班相关的响应信息
 *
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/1 1:37 下午
 */
public class FlightInfoResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 6028987252845596826L;

    private List<FlightInfo> flightInfoList;

    public List<FlightInfo> getFlightInfoList() {
        return flightInfoList;
    }

    public void setFlightInfoList(List<FlightInfo> flightInfoList) {
        this.flightInfoList = flightInfoList;
    }
}
