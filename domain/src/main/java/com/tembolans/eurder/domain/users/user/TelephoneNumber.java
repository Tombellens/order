package com.tembolans.eurder.domain.users.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TelephoneNumber {
    private final String fullTelephoneNumber;
    private final String nationality;
    private final int telephoneNumber;
    private final CountryCode countrycode;


    public TelephoneNumber(int telephoneNumber, CountryCode countrycode) {
        this.telephoneNumber = telephoneNumber;
        this.countrycode = countrycode;
        fullTelephoneNumber = "+" + countrycode.getCode()  + " " + telephoneNumber;
        nationality = countrycode.getCountry();
    }

    public String getFullTelephoneNumber() {
        return fullTelephoneNumber;
    }

    public String getNationality() {
        return nationality;
    }
}
