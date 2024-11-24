package com.diseno.demo.factory.user;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.entity.user.InsideUser;
import com.diseno.demo.entity.user.User;

public class InsideUserFactory extends UserFactory {

    @Override
    public User createUser(UserDTO userDTO) {
        return new InsideUser(
                userDTO.getEmail(),
                userDTO.getUsername(),
                userDTO.getName(),
                userDTO.getPosition(),
                userDTO.getDepartment(),
                userDTO.getUserFile(),
                userDTO.getSla());
    }
}
