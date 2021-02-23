package com.github.jay.custom.project.custom.facade.response;


import com.github.jay.custom.project.custom.facade.entity.FlightInfoDTO;

import java.util.List;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/3 10:42 下午
 */
public class FlightInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 6716174416591832785L;

    private List<FlightInfoDTO> flightInfoDTOList;

    public List<FlightInfoDTO> getFlightInfoDTOList() {
        return flightInfoDTOList;
    }

    public void setFlightInfoDTOList(List<FlightInfoDTO> flightInfoDTOList) {
        this.flightInfoDTOList = flightInfoDTOList;
    }
}
