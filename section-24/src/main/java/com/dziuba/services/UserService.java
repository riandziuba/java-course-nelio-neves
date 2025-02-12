package com.dziuba.services;

import com.dziuba.domain.User;
import com.dziuba.dto.UserDTO;
import com.dziuba.repository.UserRepository;
import com.dziuba.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        List<User> users = this.userRepository.findAll();

        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).toList();

        return usersDTO;
    }

    public UserDTO findById(String id) {
        Optional<User> user = this.userRepository.findById(id);
        return new UserDTO(user.orElseThrow(() -> new ObjectNotFoundException("Object not found")));
    }
}
