package com.cathay.coindesk.enums;

public enum StatusEnum {
	
    SUCCESS("success"), FAILED("failed");

    StatusEnum(String name) {
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
