package com.rdziuba.services;

import com.rdziuba.entities.User;
import com.rdziuba.repositories.UserRepository;
import com.rdziuba.services.exceptions.DatabaseException;
import com.rdziuba.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User user) {
        try {
            User userToUpdate = userRepository.getReferenceById(id);
            updateData(userToUpdate, user);
            return userRepository.save(userToUpdate);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User userToUpdate, User object) {
        userToUpdate.setName(object.getName());
        userToUpdate.setEmail(object.getEmail());
        userToUpdate.setPhone(object.getPhone());
    }
}
