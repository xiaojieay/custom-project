package com.github.jay.custom.project.custom.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/3 10:48 下午
 */
public class FlightInfoDTO implements Serializable {

    private static final long serialVersionUID = -7226319779744615892L;

    private String flightNo;

    private Date flightDate;

    private BigDecimal comTicketPrice;

    private BigDecimal officialPrice;

    private BigDecimal topPrice;

    private Date sellTime;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getFlightDate() {
        return new Date(flightDate.getTime());
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = new Date(flightDate.getTime());
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
        return new Date(sellTime.getTime());
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = new Date(sellTime.getTime());
    }

    @Override
    public String toString() {
        return "FlightInfoDTO{" +
                "flightNo='" + flightNo + '\'' +
                ", flightDate=" + flightDate +
                ", comTicketPrice=" + comTicketPrice +
                ", officialPrice=" + officialPrice +
                ", topPrice=" + topPrice +
                ", sellTime=" + sellTime +
                '}';
    }
}
