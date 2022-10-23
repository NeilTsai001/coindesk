package com.cathay.coindesk.model.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import com.cathay.coindesk.support.CurrencyDateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyDto {

    private String name;

    private String chineseName;

    private BigDecimal rate;

    @JsonSerialize(using = CurrencyDateSerializer.class)
    private Date updateTime;

    public CurrencyDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#,###.####");
        StringBuilder builder = new StringBuilder();
        builder.append("CurrencyDto [name=");
        builder.append(name);
        builder.append(", chineseName=");
        builder.append(chineseName);
        builder.append(", rate=");
        builder.append(format.format(rate));
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append("]");
        return builder.toString();
    }

}
