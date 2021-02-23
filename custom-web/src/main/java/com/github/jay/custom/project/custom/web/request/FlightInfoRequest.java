package com.github.jay.custom.project.custom.web.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/1 1:16 下午
 */
public class FlightInfoRequest implements Serializable {

    private static final long serialVersionUID = 6226673207405258838L;

    @NotEmpty(message = "航班号不能为null")
    private String flightNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NotNull(message = "航班日期不能为null")
    private Date flightDate;

    @NotNull(message = "经济舱价格不能为null")
    private String comTicketPrice;

    @NotNull(message = "商务舱价格不能为null")
    private String officialPrice;

    @NotNull(message = "头等舱价格不能为null")
    private String topPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NotNull
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

    public String getComTicketPrice() {
        return comTicketPrice;
    }

    public void setComTicketPrice(String comTicketPrice) {
        this.comTicketPrice = comTicketPrice;
    }

    public String getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(String officialPrice) {
        this.officialPrice = officialPrice;
    }

    public String getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(String topPrice) {
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
        return "FlightInfoRequest{" + ", flightNo='" + flightNo + '\'' + ", flightDate=" + flightDate
            + ", comTicketPrice=" + comTicketPrice + ", officialPrice=" + officialPrice + ", topPrice=" + topPrice
            + ", sellTime=" + sellTime + '}';
    }
}
