package com.tembolans.eurder.domain.users;

import com.tembolans.eurder.domain.users.exceptions.AlreadyUsedException;
import com.tembolans.eurder.domain.users.exceptions.UserNotFoundException;
import com.tembolans.eurder.domain.users.user.EmailAddress;
import com.tembolans.eurder.domain.users.user.TelephoneNumber;
import com.tembolans.eurder.domain.users.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Map<UUID, User> userRepo;

    public UserRepository(){
        this.userRepo = new ConcurrentHashMap<>();
    }

    public User registerNewUser(User userToCreate) throws AlreadyUsedException {
         validateNewUser(userToCreate);
         userRepo.put(userToCreate.getId(), userToCreate);
         return userToCreate;
    }

    private void validateNewUser(User userToCreate) throws AlreadyUsedException {
        if (checkForIdenticalEmailAddress(userToCreate.getEmail())) throw new AlreadyUsedException("email");
        if(checkForIdenticalUsername(userToCreate.getEmail().getUserName())) throw new AlreadyUsedException("username");
        if (checkForIdenticalPhoneNumber(userToCreate.getTelephoneNumber())) throw new AlreadyUsedException("phone");
    }

    private boolean checkForIdenticalPhoneNumber(TelephoneNumber telephoneNumber) {
        List<TelephoneNumber> telephoneNumbers = userRepo.values().stream()
                .map(user -> user.getTelephoneNumber())
                .collect(Collectors.toList());
        return telephoneNumbers.contains(telephoneNumber);
    }

    private boolean checkForIdenticalUsername(String userName) {
        List<String> userNames = userRepo.values().stream()
                .map(user -> user.getEmail().getUserName())
                .collect(Collectors.toList());
        return userNames.contains(userName);
    }

    private boolean checkForIdenticalEmailAddress(EmailAddress email) {
        List<EmailAddress> emailAddresses = userRepo.values().stream()
                                            .map(user -> user.getEmail())
                                            .collect(Collectors.toList());
        return emailAddresses.contains(email);
    }

    public List<User> getUsers() {
        return userRepo.values().stream()
                                .collect(Collectors.toList());
    }

    public User getUser(UUID id) {
        return userRepo.values().stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("There is no user with id: " + id));

    }
}
