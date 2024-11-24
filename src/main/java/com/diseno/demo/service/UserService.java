package com.diseno.demo.service;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.entity.user.OutsideUser;
import com.diseno.demo.entity.user.User;
import com.diseno.demo.entity.user.InsideUser;
import com.diseno.demo.exception.TicketException;
import com.diseno.demo.factory.user.InsideUserFactory;
import com.diseno.demo.factory.user.OutsideUserFactory;
import com.diseno.demo.factory.user.UserFactory;
import com.diseno.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final InsideUserFactory insideUserFactory;
    private final OutsideUserFactory outsideUserFactory;


    public void createUser(String role, UserDTO userDTO){
        User user;
        if (role.equalsIgnoreCase("INSIDE")) {
            user = insideUserFactory.createUser(userDTO);
        } else if (role.equalsIgnoreCase("OUTSIDE")) {
            user = outsideUserFactory.createUser(userDTO);
        }
        else{
            throw new TicketException("INVALID_ROLE", "Role is invalid");
        }

        userRepository.save(user);
    }

    public ResponseEntity<GetUserDTO> getUserDTOById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.getUserById(id), GetUserDTO.class));
    }

    public ResponseEntity<List<GetUserDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users.stream().map(user -> modelMapper.map(user, GetUserDTO.class)).toList());
    }

    public void updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = getUserById(id);

        if (userDTO.getName() != null){
            userToUpdate.setName(userDTO.getName());
        }
        if (userDTO.getEmail() != null){
            userToUpdate.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPassword() != null){
            userToUpdate.setPassword(userDTO.getPassword());
        }
        if (userDTO.getRole() != null){
            userToUpdate.setRole(userDTO.getRole());
        }

        userRepository.save(userToUpdate);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }
}
