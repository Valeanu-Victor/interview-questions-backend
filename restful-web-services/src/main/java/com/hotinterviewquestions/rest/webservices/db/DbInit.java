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

        userRepository.deleteAll();
        questionsJpaRepository.deleteAll();

        UserDto victor = new UserDto("victor@test.com", passwordEncoder.encode("victor123"), 1, "", "");
        UserDto admin = new UserDto("admin", passwordEncoder.encode("admin123"), 1, "", "");

        User victorEntity = userMapper.toEntity(victor);
        User adminEntity = userMapper.toEntity(admin);

        QuestionDto question1 = new QuestionDto("What is Docker?", "Docker is an open-source lightweight containerization technology. It has gained widespread popularity in the cloud and application packaging world. It allows you to automate the deployment of applications in lightweight and portable containers.", "Junior", "Docker");
        QuestionDto question2 = new QuestionDto("What is Docker Engine?", "Docker daemon or Docker engine represents the server. The docker daemon and the clients should be run on the same or remote host, which can communicate through command-line client binary and full RESTful API.", "Intermediate", "Docker");
        QuestionDto question3 = new QuestionDto("What command should you run to see all running container in Docker?", "$ docker ps", "Junior", "Docker");

        Question questionEntity1 = questionMapper.toEntity(question1);
        Question questionEntity2 = questionMapper.toEntity(question2);
        Question questionEntity3 = questionMapper.toEntity(question3);

        Set<Question> questions = new HashSet<>();
        questions.add(questionEntity1);
        questions.add(questionEntity2);
        questions.add(questionEntity3);

        List<User> users = Arrays.asList(victorEntity, adminEntity);

        this.questionsJpaRepository.saveAll(questions);
        this.userRepository.saveAll(users);
    }
}
