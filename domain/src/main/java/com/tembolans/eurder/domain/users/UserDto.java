package com.tembolans.eurder.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.users.user.EmailAddress;
import com.tembolans.eurder.domain.users.user.TelephoneNumber;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import java.util.UUID;

@JsonAutoDetect
@RequiredArgsConstructor
public class UserDto {
    private final @NonNull UUID id;
    private final @NonNull String firstname;
    private final @NonNull String lastname;
    private final @NonNull EmailAddress emailAddress;
    private final @NonNull TelephoneNumber telephoneNumber;

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }
}
