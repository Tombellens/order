package com.tembolans.eurder.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.users.exceptions.InvalidEmailException;
import com.tembolans.eurder.domain.users.exceptions.InvalidPhoneNumberException;
import com.tembolans.eurder.domain.users.user.CountryCode;
import com.tembolans.eurder.domain.users.user.EmailAddress;
import com.tembolans.eurder.domain.users.user.TelephoneNumber;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@JsonAutoDetect
@RequiredArgsConstructor
public class CreateUserDto {
    public static final int TELEPHONE_NUMBER_LENGTH = 9;

    private final @NonNull String firstname;
    private final @NonNull String lastname;
    private final @NonNull String emailAddress;
    private final @NonNull String telephoneNumber;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public EmailAddress getEmailAddress() throws InvalidEmailException {
        String[] emailArray = validateEmail(emailAddress);
        return new EmailAddress(emailArray[0], emailArray[1]);
    }

    private String[] validateEmail(String emailAddress) throws InvalidEmailException {
        if (!emailAddress.contains("@")) throw new InvalidEmailException("should contain an '@'");
        String[] emailArray = emailAddress.split("@");
        if (emailArray.length != 2 || emailArray[0].length() == 0 || emailArray[1].length() == 0) throw new InvalidEmailException(" should have the following format -> username @ domain");
        return emailArray;
    }

    public TelephoneNumber getTelephoneNumber() throws InvalidPhoneNumberException {
        String[] telephoneNumberArray = validatePhoneNumber(telephoneNumber);
        return new TelephoneNumber(Integer.parseInt(telephoneNumberArray[1]),getCountryCode(telephoneNumberArray[0]));
    }

    private CountryCode getCountryCode(String countryCodeString){
        int countryCodeInt = Integer.parseInt(countryCodeString.substring(1,3));

        for (int i = 0; i < CountryCode.values().length; i++){
            if (countryCodeInt == CountryCode.values()[i].getCode()) return CountryCode.values()[i];
        }

        throw new InvalidEmailException("Unknown error");
    }

    private String[] validatePhoneNumber(String telephoneNumber) throws InvalidPhoneNumberException {
        if(telephoneNumber.charAt(0) != '+') throw new InvalidPhoneNumberException("should start with countrycode");
        String[] telephoneNumberArray = {telephoneNumber.substring(0,3), telephoneNumber.substring(3)};
        if (!validateCountryCode(telephoneNumberArray[0])) throw new InvalidPhoneNumberException("invalid country code");
        if (!validateSecondPartOfTelephoneNumber(telephoneNumberArray[1])) throw new InvalidPhoneNumberException("phone number should only contain " +
                + TELEPHONE_NUMBER_LENGTH + " numbers" ) ;
        return telephoneNumberArray;
    }

    private boolean validateSecondPartOfTelephoneNumber(String secondPartString) {
        try{
            int secondPart = Integer.parseInt(secondPartString);
            return (secondPartString.length() == TELEPHONE_NUMBER_LENGTH);
        }catch(NumberFormatException exception){
            throw new InvalidPhoneNumberException(" telephone number should only contain numbers");
        }
    }

    private boolean validateCountryCode(String countryCode) {
        try {
            int countryInteger = Integer.parseInt(countryCode.substring(1, 3));
            for (int i = 0; i < CountryCode.values().length; i++){
                if (countryInteger == CountryCode.values()[i].getCode()) return true;
            }
            return false;
        }catch (NumberFormatException exception){
            throw new InvalidPhoneNumberException("invalid country code, should only contain numbers");
        }
    }
}
