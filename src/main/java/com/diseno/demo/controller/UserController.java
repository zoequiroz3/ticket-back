package com.diseno.demo.controller;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.dto.response.GetUserDTO;
import com.diseno.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public void createUser(@RequestParam("role") String role, @RequestBody UserDTO userDTO) {
        userService.createUser(role, userDTO);
    }

    @GetMapping
    public ResponseEntity<List<GetUserDTO>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }
}
