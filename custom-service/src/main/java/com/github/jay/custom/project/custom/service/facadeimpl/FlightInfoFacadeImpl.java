package com.github.jay.custom.project.custom.service.facadeimpl;

import com.github.jay.custom.project.custom.common.enums.ResponseStatusEnum;
import com.github.jay.custom.project.custom.facade.FlightInfoFacade;
import com.github.jay.custom.project.custom.facade.entity.FlightInfoDTO;
import com.github.jay.custom.project.custom.facade.response.FlightInfoResponse;
import com.github.jay.custom.project.custom.service.FlightInfoService;
import com.github.jay.custom.project.custom.service.entity.FlightInfo;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/3 10:54 下午
 */
@DubboService(version = "1.0", interfaceName = "flightInfoFacade",group = "custom-project")
public class FlightInfoFacadeImpl implements FlightInfoFacade {

    @Resource(name = "flightInfoService")
    private FlightInfoService flightInfoService;

    @Override
    public FlightInfoResponse getAllFlightInfo() {
        Optional<List<FlightInfo>> flightInfoList = Optional.ofNullable(flightInfoService.flightInfos());
        Optional<List<FlightInfoDTO>> flightInfoDTOList =
            flightInfoList.map(infoS -> infoS.stream().map(this::convertFightInfoDTO).collect(Collectors.toList()));
        FlightInfoResponse flightInfoResponse = new FlightInfoResponse();
        flightInfoResponse.setFlightInfoDTOList(
            flightInfoDTOList.filter(flightInfoS -> flightInfoS.size() > 0).orElse(new ArrayList<>()));
        flightInfoResponse.setCode(ResponseStatusEnum.SUCCESS.getCode());
        flightInfoResponse.setMessage(ResponseStatusEnum.SUCCESS.getMessage());
        return flightInfoResponse;
    }

    private FlightInfoDTO convertFightInfoDTO(FlightInfo flightInfo) {
        FlightInfoDTO flightInfoDTO = new FlightInfoDTO();
        Optional.ofNullable(flightInfo.getFlightNo()).ifPresent(flightInfoDTO::setFlightNo);
        Optional.ofNullable(flightInfo.getFlightDate()).ifPresent(flightInfoDTO::setFlightDate);
        Optional.ofNullable(flightInfo.getComTicketPrice()).ifPresent(
            comTicketPrice -> flightInfoDTO.setComTicketPrice(new BigDecimal(String.valueOf(comTicketPrice))));
        Optional.ofNullable(flightInfo.getOfficialPrice())
            .ifPresent(officialPrice -> flightInfoDTO.setOfficialPrice(new BigDecimal(String.valueOf(officialPrice))));
        Optional.ofNullable(flightInfo.getTopPrice())
            .ifPresent(topPrice -> flightInfoDTO.setTopPrice(new BigDecimal(String.valueOf(topPrice))));
        Optional.ofNullable(flightInfo.getSellTime()).ifPresent(flightInfoDTO::setSellTime);
        return flightInfoDTO;
    }
}
