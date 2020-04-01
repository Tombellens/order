package com.tembolans.eurder.domain.users;

import com.tembolans.eurder.domain.users.user.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    Map<UUID, User> userRepo;

    public UserRepository(){
        this.userRepo = new ConcurrentHashMap<>();
    }

    public User registerNewUser(User userToCreate){
         userRepo.put(userToCreate.getId(), userToCreate);
         return userToCreate;
    }
}
