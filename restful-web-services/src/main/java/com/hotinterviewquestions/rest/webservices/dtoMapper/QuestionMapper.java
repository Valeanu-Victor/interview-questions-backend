package com.hotinterviewquestions.rest.webservices.dtoMapper;

import com.hotinterviewquestions.rest.webservices.dto.QuestionDto;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question toEntity(QuestionDto dto) {
        Question entity = new Question();

        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        entity.setCategory(dto.getCategory());
        entity.setDifficulty(dto.getDifficulty());

        return entity;
    }
}
