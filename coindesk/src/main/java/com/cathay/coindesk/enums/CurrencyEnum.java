package com.cathay.coindesk.enums;

public enum CurrencyEnum {
	
    USD("USD"), GBP("USD"), EUR("EUR");

    CurrencyEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
