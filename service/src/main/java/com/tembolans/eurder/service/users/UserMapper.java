package com.tembolans.eurder.service.users;

import com.tembolans.eurder.domain.users.CreateUserDto;
import com.tembolans.eurder.domain.users.UserDto;
import com.tembolans.eurder.domain.users.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto fromUserToUserDto(User user){
        return new UserDto(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getTelephoneNumber());
    }

    public User fromCreateUserDtotoUser(CreateUserDto createUserDto){
        return new User(UUID.randomUUID(), createUserDto.getFirstname(), createUserDto.getLastname(), createUserDto.getEmailAddress(), createUserDto.getTelephoneNumber());
    }

    public List<UserDto> fromUserToUserDto(List<User> users) {
        return users.stream()
                .map(user -> fromUserToUserDto(user))
                .collect(Collectors.toList());
    }
}
