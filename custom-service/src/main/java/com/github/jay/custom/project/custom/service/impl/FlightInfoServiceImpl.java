package com.github.jay.custom.project.custom.service.impl;

import com.github.jay.custom.project.custom.dal.dao.FlightInfoMapper;
import com.github.jay.custom.project.custom.dal.entity.FlightInfoDO;
import com.github.jay.custom.project.custom.service.FlightInfoService;
import com.github.jay.custom.project.custom.service.entity.FlightInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/30 11:09 上午
 */
@DubboService(interfaceName = "flightInfoService", version = "1.0.0", group = "custom-project")
@org.springframework.stereotype.Service("flightInfoService")
public class FlightInfoServiceImpl implements FlightInfoService {

    @Resource
    private FlightInfoMapper flightInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertFlightInfo(FlightInfo flightInfo) {
        return flightInfoMapper.insertSelective(convertFightInfoDO(flightInfo)) == 1;
    }

    @Override
    public List<FlightInfo> flightInfos() {
        Optional<List<FlightInfoDO>> flightInfoDOList =
            Optional.ofNullable(flightInfoMapper.selectAll()).filter(flightInfoDoS -> flightInfoDoS.size() > 0);
        Optional<List<FlightInfo>> flightInfoListOptional =
            flightInfoDOList.map(infoS -> infoS.stream().map(this::convertFightInfoVO).collect(Collectors.toList()));
        return flightInfoListOptional.filter(flightInfoS -> flightInfoS.size() > 0).orElse(new ArrayList<>());
    }

    private FlightInfoDO convertFightInfoDO(FlightInfo flightInfo) {
        FlightInfoDO flightInfoDO = new FlightInfoDO();
        Optional.ofNullable(flightInfo.getFlightNo()).ifPresent(flightInfoDO::setFlightNo);
        Optional.ofNullable(flightInfo.getFlightDate()).ifPresent(flightInfoDO::setFlightDate);
        Optional.ofNullable(flightInfo.getComTicketPrice()).ifPresent(
            comTicketPrice -> flightInfoDO.setComTicketPrice(new BigDecimal(String.valueOf(comTicketPrice))));
        Optional.ofNullable(flightInfo.getOfficialPrice())
            .ifPresent(officialPrice -> flightInfoDO.setOfficialPrice(new BigDecimal(String.valueOf(officialPrice))));
        Optional.ofNullable(flightInfo.getTopPrice())
            .ifPresent(topPrice -> flightInfoDO.setTopPrice(new BigDecimal(String.valueOf(topPrice))));
        Optional.ofNullable(flightInfo.getSellTime()).ifPresent(flightInfoDO::setSellTime);
        return flightInfoDO;
    }

    private FlightInfo convertFightInfoVO(FlightInfoDO flightInfoDO) {
        FlightInfo flightInfo = new FlightInfo();
        Optional.ofNullable(flightInfoDO.getFlightNo()).ifPresent(flightInfo::setFlightNo);
        Optional.ofNullable(flightInfoDO.getFlightDate()).ifPresent(flightInfo::setFlightDate);
        Optional.ofNullable(flightInfoDO.getComTicketPrice())
            .ifPresent(comTicketPrice -> flightInfo.setComTicketPrice(new BigDecimal(String.valueOf(comTicketPrice))));
        Optional.ofNullable(flightInfoDO.getOfficialPrice())
            .ifPresent(officialPrice -> flightInfo.setOfficialPrice(new BigDecimal(String.valueOf(officialPrice))));
        Optional.ofNullable(flightInfoDO.getTopPrice())
            .ifPresent(topPrice -> flightInfo.setTopPrice(new BigDecimal(String.valueOf(topPrice))));
        Optional.ofNullable(flightInfoDO.getSellTime()).ifPresent(flightInfo::setSellTime);
        return flightInfo;
    }
}
