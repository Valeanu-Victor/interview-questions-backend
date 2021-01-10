package com.hotinterviewquestions.rest.webservices.db;

import com.hotinterviewquestions.rest.webservices.dto.QuestionDto;
import com.hotinterviewquestions.rest.webservices.dtoMapper.QuestionMapper;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.repository.QuestionsJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private QuestionsJpaRepository questionsJpaRepository;

    private QuestionMapper questionMapper;

    public DbInit(QuestionsJpaRepository questionsJpaRepository, QuestionMapper questionMapper) {
        this.questionsJpaRepository = questionsJpaRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public void run(String... args) {
        QuestionDto question1 = new QuestionDto("question", "answer", "Junior", "Docker");
        QuestionDto question2 = new QuestionDto("question2", "answer2", "Intermediate", "Java8Features");
        QuestionDto question3 = new QuestionDto("question3", "answer3", "Advanced", "Angular2");

        Question questionEntity1 = questionMapper.toEntity(question1);
        Question questionEntity2 = questionMapper.toEntity(question2);
        Question questionEntity3 = questionMapper.toEntity(question3);

        Set<Question> questions = new HashSet<>();
        questions.add(questionEntity1);
        questions.add(questionEntity2);
        questions.add(questionEntity3);

        this.questionsJpaRepository.saveAll(questions);
    }
}
