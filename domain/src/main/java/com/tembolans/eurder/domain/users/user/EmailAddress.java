package com.tembolans.eurder.domain.users.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

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
}
