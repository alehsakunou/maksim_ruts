package com.epam.jmp.webservices.controller;

import com.epam.jmp.webservices.domain.User;
import com.epam.jmp.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Maksim Ruts on 10/29/2016.
 * REST controller for user management
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * GET all method with pagination
     * @param pageable page settings for users selection
     * @return page of selected users
     */
    @GetMapping
    public ResponseEntity<Page<User>> getUsers(final Pageable pageable) {
        return new ResponseEntity<>(userRepository.findAll(pageable), HttpStatus.OK);
    }

    /**
     * GET user method
     * @param id id of requested user
     * @return requested user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") final Long id) {
        if (userRepository.exists(id)) {
            return new ResponseEntity<>(userRepository.findOne(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * POST user methos
     * @param user user for saving
     * @return stored user
     */
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody final User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    /**
     * PUT user method
     * @param user user for updating
     * @param id user id for updating
     * @return updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody final User user, @PathVariable final Long id) {
        if (userRepository.exists(id)) {
            user.setId(id);
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * DELETE user method
     * @param id user id for deleting
     * @return id of deleted user
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable final Long id) {
        if (userRepository.exists(id)) {
            userRepository.delete(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
