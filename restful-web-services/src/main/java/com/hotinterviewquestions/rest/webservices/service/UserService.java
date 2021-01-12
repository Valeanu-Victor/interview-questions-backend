package com.hotinterviewquestions.rest.webservices.service;

import com.hotinterviewquestions.rest.webservices.dto.UserDto;
import com.hotinterviewquestions.rest.webservices.dtoMapper.UserMapper;
import com.hotinterviewquestions.rest.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<HttpStatus> createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userRepository.save(userMapper.toEntity(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
