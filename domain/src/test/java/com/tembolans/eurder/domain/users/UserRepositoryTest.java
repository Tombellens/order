package com.tembolans.eurder.domain.users;

import com.tembolans.eurder.domain.users.exceptions.AlreadyUsedException;
import com.tembolans.eurder.domain.users.user.CountryCode;
import com.tembolans.eurder.domain.users.user.EmailAddress;
import com.tembolans.eurder.domain.users.user.TelephoneNumber;
import com.tembolans.eurder.domain.users.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;


class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    public void setup(){
        userRepository = new UserRepository();
        User userTom = new User(UUID.randomUUID(), "Tom", "Bellens",
                                new EmailAddress("tombellens96", "hotmail.com"),
                                new TelephoneNumber(489354392, CountryCode.be));
        userRepository.registerNewUser(userTom);
    }


    @Nested
    class alreadyExistsValidation{
        @Test
        void emailAlreadyExists() {
            //GIVEN
            User userTimWithSameEmail = new User(UUID.randomUUID(), "Tim", "Bellens",
                    new EmailAddress("tombellens96", "hotmail.com"),
                    new TelephoneNumber(499354395, CountryCode.be));


            //THEN
            Assertions.assertThrows(AlreadyUsedException.class,() -> userRepository.registerNewUser(userTimWithSameEmail));

        }

        @Test
        void phoneAlreadyExists() {
            //GIVEN
            User userTimWithSameEmail = new User(UUID.randomUUID(), "Tim", "Bellens",
                    new EmailAddress("timbellens96", "hotmail.com"),
                    new TelephoneNumber(489354392, CountryCode.be));


            //THEN
            Assertions.assertThrows(AlreadyUsedException.class,() -> userRepository.registerNewUser(userTimWithSameEmail));
        }

        @Test
        void userNameAlreadyExists() {
            //GIVEN
            User userTimWithSameEmail = new User(UUID.randomUUID(), "Tim", "Bellens",
                    new EmailAddress("tombellens96", "gotmail.com"),
                    new TelephoneNumber(499364395, CountryCode.be));


            //THEN
            Assertions.assertThrows(AlreadyUsedException.class,() -> userRepository.registerNewUser(userTimWithSameEmail));
        }

        @Test
        void uniqueUser() {
            //GIVEN
            User userChrissy = new User(UUID.randomUUID(), "Chrissy", "Engelen",
                    new EmailAddress("chrissyengelen99", "gmail.com"),
                    new TelephoneNumber(475364395, CountryCode.be));
            //THEN
            Assertions.assertEquals(userRepository.registerNewUser(userChrissy), userChrissy);
        }
    }


}