package com.hotinterviewquestions.rest.webservices.repository;

import com.hotinterviewquestions.rest.webservices.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionsJpaRepository extends JpaRepository<Question, Long> {
    Set<Question> findByCategory(String category);
}
