package com.hotinterviewquestions.rest.webservices.controller;

import com.hotinterviewquestions.rest.webservices.dto.UserDto;
import com.hotinterviewquestions.rest.webservices.dto.view.RegisterView;
import com.hotinterviewquestions.rest.webservices.entity.User;
import com.hotinterviewquestions.rest.webservices.repository.UserRepository;
import com.hotinterviewquestions.rest.webservices.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/all")
    public List<User> users(){
        return this.userRepository.findAll();
    }

    @PostMapping(
            value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<HttpStatus> register(@RequestBody RegisterView registerView) {
        System.out.println(registerView.toString());

        UserDto userDto = new UserDto();
        registerView.setPassword(passwordEncoder.encode(registerView.getPassword()));
        registerView.setActive(1);
        BeanUtils.copyProperties(registerView, userDto);

        return userService.createUser(userDto);
    }
}
