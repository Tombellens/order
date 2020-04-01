package com.tembolans.eurder.api.users;


import com.tembolans.eurder.domain.users.CreateUserDto;
import com.tembolans.eurder.domain.users.UserDto;
import com.tembolans.eurder.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

    UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto);
    }
}
