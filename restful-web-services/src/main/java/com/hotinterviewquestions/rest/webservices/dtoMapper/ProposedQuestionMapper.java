package com.hotinterviewquestions.rest.webservices.dtoMapper;

import com.hotinterviewquestions.rest.webservices.dto.ProposedQuestionDto;
import com.hotinterviewquestions.rest.webservices.entity.ProposedQuestion;
import org.springframework.stereotype.Component;

@Component
public class ProposedQuestionMapper {

    public ProposedQuestion toEntity(ProposedQuestionDto dto) {
        ProposedQuestion entity = new ProposedQuestion();

        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        entity.setCategory(dto.getCategory());
        entity.setDifficulty(dto.getDifficulty());

        return entity;
    }
}
