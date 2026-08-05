package com.example.booking_system2.springBConfig.userConfig;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
     @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody @Valid UserRequest userToCreate
     ){
        log.info("Called to createUser");
           return ResponseEntity.status(HttpStatus.CREATED).
                   body(userService.createUser(userToCreate));
     }

}
