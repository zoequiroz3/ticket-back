package com.diseno.demo.factory.user;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.entity.user.OutsideUser;
import com.diseno.demo.entity.user.User;

public class OutsideUserFactory implements UserFactory {
    @Override
    public User createUser(UserDTO userDTO) {
        return new OutsideUser(
                userDTO.getEmail(),
                userDTO.getUsername(),
                userDTO.getName(),
                userDTO.getPosition(),
                userDTO.getDepartment(),
                userDTO.getUserFile(),
                userDTO.getCuil(),
                userDTO.getDescription(),
                userDTO.getCompany(),
                userDTO.getSla()
        );
    }
}
