package com.hotinterviewquestions.rest.webservices.service;

import com.hotinterviewquestions.rest.webservices.dto.ProposedQuestionDto;
import com.hotinterviewquestions.rest.webservices.entity.ProposedQuestion;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.dto.view.UserSelectionsView;
import com.hotinterviewquestions.rest.webservices.repository.ProposedQuestionJpaRespository;
import com.hotinterviewquestions.rest.webservices.repository.QuestionsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsJpaRepository questionsJpaRepository;
    @Autowired
    private ProposedQuestionJpaRespository proposedQuestionJpaRespository;

    public Set<Question> findByDifficultyAndCategory(UserSelectionsView userSelectionsView) {
        Set<Question> questionSet = new HashSet<>();

        for (String category : userSelectionsView.getCategories()) {
            if (questionsJpaRepository.findByCategory(category) != null) {
                Set<Question> temp = questionsJpaRepository.findByCategory(category);
                for (String difficulty : userSelectionsView.getDifficulties()) {
                    questionSet.addAll(temp
                            .stream()
                            .filter(q -> q.getDifficulty().equals(difficulty))
                            .collect(Collectors.toSet()));
                }
            }
        }

        return questionSet;
    }

    public Set<Question> getAllQuestions() {
        return new HashSet<>(questionsJpaRepository.findAll());
    }

    public ResponseEntity<HttpStatus> saveProposedQuestion(ProposedQuestion proposedQuestion) {
        proposedQuestionJpaRespository.save(proposedQuestion);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean isProposedQuestionValid(ProposedQuestionDto dto) {
        if (
        dto.getQuestion() == null || dto.getQuestion().equals("") ||
        dto.getAnswer() == null || dto.getAnswer().equals("") ||
        dto.getDifficulty() == null || dto.getDifficulty().equals("") ||
        dto.getCategory() == null || dto.getCategory().equals("")
        ) {
            return false;
        }

        return true;
    }

    public ArrayList<ProposedQuestion> getAllProposedQuestions() {
        return new ArrayList<>(proposedQuestionJpaRespository.findAll());
    }
}
