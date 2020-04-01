package com.tembolans.eurder.service.users;

import com.tembolans.eurder.domain.users.CreateUserDto;
import com.tembolans.eurder.domain.users.UserDto;
import com.tembolans.eurder.domain.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        return userMapper.fromUserToUserDto(userRepository.registerNewUser(userMapper.fromCreateUserDtotoUser(createUserDto)));
    }
}
