package com.diseno.demo.factory.user;

import com.diseno.demo.dto.request.UserDTO;
import com.diseno.demo.entity.user.User;

public interface UserFactory {
    public abstract User createUser(UserDTO userDTO);
}
