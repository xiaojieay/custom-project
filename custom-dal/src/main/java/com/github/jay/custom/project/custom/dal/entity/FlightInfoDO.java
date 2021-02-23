package com.github.jay.custom.project.custom.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/29 4:38 下午
 */
public class FlightInfoDO {

    private Long id;

    private String flightNo;

    private Date flightDate;

    private BigDecimal comTicketPrice;

    private BigDecimal officialPrice;

    private BigDecimal topPrice;

    private Date sellTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public BigDecimal getComTicketPrice() {
        return comTicketPrice;
    }

    public void setComTicketPrice(BigDecimal comTicketPrice) {
        this.comTicketPrice = comTicketPrice;
    }

    public BigDecimal getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(BigDecimal officialPrice) {
        this.officialPrice = officialPrice;
    }

    public BigDecimal getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    @Override
    public String toString() {
        return "FlightInfoDO{" + "flightNo='" + flightNo + '\'' + ", flightDate=" + flightDate + ", comTicketPrice="
            + comTicketPrice + ", officialPrice=" + officialPrice + ", topPrice=" + topPrice + ", sellTime=" + sellTime
            + '}';
    }
}