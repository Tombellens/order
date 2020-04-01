package com.tembolans.eurder.domain.users.user;

public enum CountryCode {
    be("Belgium",32), fr("France",33);

    private String country;
    private int code;

    CountryCode(String country, int code) {
        this.country = country;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }


}
