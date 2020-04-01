package com.tembolans.eurder.domain.users;

import com.tembolans.eurder.domain.users.exceptions.InvalidEmailException;
import com.tembolans.eurder.domain.users.exceptions.InvalidPhoneNumberException;
import com.tembolans.eurder.domain.users.user.CountryCode;
import com.tembolans.eurder.domain.users.user.EmailAddress;
import com.tembolans.eurder.domain.users.user.TelephoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserDtoTest {
    private CreateUserDto createUserDto;

    @BeforeEach
    public void setUp(){

    }

    @Nested
   class emailAddress{
        @Test
        void givenAValidEmailAddress_ShouldReturnRightEmailaddress() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@hotmail.com", "+32489354392");
            EmailAddress email = new EmailAddress("tombellens96", "hotmail.com");
            //THEN
            Assertions.assertEquals(createUserDto.getEmailAddress(), email);
        }

        @Test
        void givenEmailAddressWithoutAt_ShouldThrowInvalidEmailException() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96hotmail.com", "+32489354392");

            //THEN
            Assertions.assertThrows(InvalidEmailException.class,() -> createUserDto.getEmailAddress());
        }

        @Test
        void givenEmailAddressWithoutUsername_ShouldThrowInvalidEmailException() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "@hotmail.com", "+32489354392");

            //THEN
            Assertions.assertThrows(InvalidEmailException.class,() -> createUserDto.getEmailAddress());
        }

        @Test
        void givenEmailAddressWithoutDomain_ShouldThrowInvalidEmailException() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@", "+32489354392");

            //THEN
            Assertions.assertThrows(InvalidEmailException.class,() -> createUserDto.getEmailAddress());
        }
    }

    @Nested
    class telephoneNumber{
        @Test
        void givenAValidTelephoneNumber_ShouldReturnRightTelephoneNumber() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@hotmail.com", "+32489354392");
            TelephoneNumber telephoneNumber = new TelephoneNumber(489354392, CountryCode.be);
            //THEN
            Assertions.assertEquals(createUserDto.getTelephoneNumber(), telephoneNumber);
        }

        @Test
        void givenInvalidCountryCode_ShouldThrowInvalidTelephoneNumber() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@hotmail.com", "32489354392");
            TelephoneNumber telephoneNumber = new TelephoneNumber(489354392, CountryCode.be);
            //THEN
            Assertions.assertThrows(InvalidPhoneNumberException.class,() -> createUserDto.getTelephoneNumber());
        }

        @Test
        void givenNonExistingCountryCode_ShouldThrowInvalidTelephoneNumber() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@hotmail.com", "+99489354392");
            TelephoneNumber telephoneNumber = new TelephoneNumber(489354392, CountryCode.be);
            //THEN
            Assertions.assertThrows(InvalidPhoneNumberException.class,() -> createUserDto.getTelephoneNumber());
        }

        @Test
        void givenTooLongPhoneNumber_ShouldThrowInvalidTelephoneNumber() {
            //GIVEN
            createUserDto = new CreateUserDto("Tom", "Bellens", "tombellens96@hotmail.com", "+324893543925");
            TelephoneNumber telephoneNumber = new TelephoneNumber(489354392, CountryCode.be);
            //THEN
            Assertions.assertThrows(InvalidPhoneNumberException.class,() -> createUserDto.getTelephoneNumber());
        }
    }
}