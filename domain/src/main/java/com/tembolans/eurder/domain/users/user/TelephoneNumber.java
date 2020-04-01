package com.tembolans.eurder.domain.users.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return telephoneNumber == that.telephoneNumber &&
                Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, telephoneNumber);
    }
}
