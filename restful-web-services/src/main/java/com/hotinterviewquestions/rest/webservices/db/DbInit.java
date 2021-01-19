package com.hotinterviewquestions.rest.webservices.db;

import com.hotinterviewquestions.rest.webservices.dto.QuestionDto;
import com.hotinterviewquestions.rest.webservices.dto.UserDto;
import com.hotinterviewquestions.rest.webservices.dtoMapper.QuestionMapper;
import com.hotinterviewquestions.rest.webservices.dtoMapper.UserMapper;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.entity.User;
import com.hotinterviewquestions.rest.webservices.repository.QuestionsJpaRepository;
import com.hotinterviewquestions.rest.webservices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private QuestionMapper questionMapper;
    private QuestionsJpaRepository questionsJpaRepository;

    public DbInit(UserRepository userRepository, QuestionMapper questionMapper,
                  PasswordEncoder passwordEncoder, UserMapper userMapper,
                  QuestionsJpaRepository questionsJpaRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.questionMapper = questionMapper;
        this.questionsJpaRepository = questionsJpaRepository;
    }

    @Override
    public void run(String... args) {
        // everything here is hardcoded for now for the purpose of seeing how the application demo runs


    }
}
