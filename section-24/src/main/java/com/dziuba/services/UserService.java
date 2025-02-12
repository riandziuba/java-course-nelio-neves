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

    public User insert(User user) {
        return this.userRepository.insert(user);
    }

    public void delete(String id) {
        this.findById(id);
        this.userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
