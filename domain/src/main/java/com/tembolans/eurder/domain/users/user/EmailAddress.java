package com.tembolans.eurder.domain.users.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect
public class EmailAddress {

    private final String fullEmail;

    private final String userName;
    private final String domainName;

    public EmailAddress(String userName, String domainName) {
        this.userName = userName;
        this.domainName = domainName;
        fullEmail =userName + "@" + domainName;
    }

    @Override
    public String toString() {
        return fullEmail;
    }

    public String getFullEmail() {
        return fullEmail;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return userName.equals(that.userName) &&
                domainName.equals(that.domainName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, domainName);
    }
}
