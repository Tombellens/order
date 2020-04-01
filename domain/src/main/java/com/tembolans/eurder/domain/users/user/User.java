package com.tembolans.eurder.domain.users.user;

import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
public class User {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final EmailAddress email;
    private final TelephoneNumber telephoneNumber;

    public User(UUID id, String firstname, String lastname, EmailAddress email, TelephoneNumber telephoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }
}
