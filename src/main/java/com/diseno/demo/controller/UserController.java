package com.diseno.demo.controller;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public void createUser(@RequestParam("rol") String rol, UserDTO userDTO) {
        userService.createUser(rol, userDTO);
    }
}
