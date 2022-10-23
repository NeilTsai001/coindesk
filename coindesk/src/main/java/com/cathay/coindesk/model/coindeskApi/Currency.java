package com.cathay.coindesk.model.coindeskApi;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "rate")
    private String rate;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "rate_float")
    private BigDecimal rateFloat;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(BigDecimal rateFloat) {
        this.rateFloat = rateFloat;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Currency [code=");
        builder.append(code);
        builder.append(", symbol=");
        builder.append(symbol);
        builder.append(", rate=");
        builder.append(rate);
        builder.append(", description=");
        builder.append(description);
        builder.append(", rateFloat=");
        builder.append(rateFloat);
        builder.append("]");
        return builder.toString();
    }

}
