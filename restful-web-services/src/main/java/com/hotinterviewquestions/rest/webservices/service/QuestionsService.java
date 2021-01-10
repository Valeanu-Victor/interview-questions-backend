package com.hotinterviewquestions.rest.webservices.service;

import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.dto.view.UserSelectionsView;
import com.hotinterviewquestions.rest.webservices.repository.QuestionsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsJpaRepository questionsJpaRepository;

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

    public Set<Question> getAll() {
        return questionsJpaRepository.findAll().stream().collect(Collectors.toSet());
    }
}
