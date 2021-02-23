package com.github.jay.custom.project.custom.web.controller;

import com.github.jay.custom.project.custom.common.enums.ResponseStatusEnum;
import com.github.jay.custom.project.custom.service.FlightInfoService;
import com.github.jay.custom.project.custom.service.entity.FlightInfo;
import com.github.jay.custom.project.custom.web.request.FlightInfoRequest;
import com.github.jay.custom.project.custom.web.response.BaseResponse;
import com.github.jay.custom.project.custom.web.response.FlightInfoResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/30 1:35 下午
 */
@RestController
@RequestMapping(value = "flightInfo")
public class FlightInController {

    @Resource(name = "flightInfoService")
    private FlightInfoService flightInfoService;

    @GetMapping(value = "/flightInfos")
    public FlightInfoResponse flightInfoList() {
        List<FlightInfo> flightInfoList = flightInfoService.flightInfos();
        FlightInfoResponse flightInfoResponse = new FlightInfoResponse();
        flightInfoResponse.setResponseCode(ResponseStatusEnum.SUCCESS.getCode());
        flightInfoResponse.setResponseMessage(ResponseStatusEnum.SUCCESS.getMessage());
        Optional.ofNullable(flightInfoList).ifPresent(flightInfoResponse::setFlightInfoList);
        return flightInfoResponse;
    }

    @PostMapping(value = "/flightInfo")
    public BaseResponse insertFlightInfo(@Valid @RequestBody FlightInfoRequest flightInfoRequest) {
        return flightInfoService.insertFlightInfo(convertFlightInfoRequest(flightInfoRequest))
            ? new BaseResponse(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMessage())
            : new BaseResponse(ResponseStatusEnum.FAIL.getCode(), ResponseStatusEnum.FAIL.getMessage());
    }

    private FlightInfo convertFlightInfoRequest(FlightInfoRequest flightInfoRequest) {

        FlightInfo flightInfo = new FlightInfo();
        Optional.ofNullable(flightInfoRequest.getFlightNo()).ifPresent(flightInfo::setFlightNo);
        Optional.ofNullable(flightInfoRequest.getFlightDate()).ifPresent(flightInfo::setFlightDate);
        Optional.ofNullable(flightInfoRequest.getComTicketPrice())
            .ifPresent(comTicketPrice -> flightInfo.setComTicketPrice(new BigDecimal(comTicketPrice)));
        Optional.ofNullable(flightInfoRequest.getOfficialPrice())
            .ifPresent(officialPrice -> flightInfo.setOfficialPrice(new BigDecimal(officialPrice)));
        Optional.ofNullable(flightInfoRequest.getTopPrice())
            .ifPresent(topPrice -> flightInfo.setTopPrice(new BigDecimal(topPrice)));
        Optional.ofNullable(flightInfoRequest.getSellTime()).ifPresent(flightInfo::setSellTime);
        return flightInfo;
    }
}
