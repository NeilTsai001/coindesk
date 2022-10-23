package com.cathay.coindesk.enums;

public enum TimeZoneEnum {
	
    UTC("UTC"), ISO("GMT-01"), BST("Europe/London");

    TimeZoneEnum(String name) {
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
