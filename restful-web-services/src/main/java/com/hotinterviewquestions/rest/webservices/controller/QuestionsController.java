package com.hotinterviewquestions.rest.webservices.controller;

import com.hotinterviewquestions.rest.webservices.dto.ProposedQuestionDto;
import com.hotinterviewquestions.rest.webservices.dtoMapper.ProposedQuestionMapper;
import com.hotinterviewquestions.rest.webservices.entity.ProposedQuestion;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.dto.view.UserSelectionsView;
import com.hotinterviewquestions.rest.webservices.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private ProposedQuestionMapper proposedQuestionMapper;

    @PostMapping(
            value = "/interview-questions/selected",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Set<Question>> retrieveAll(@RequestBody UserSelectionsView userSelectionsView) {
        System.out.println(userSelectionsView);
        Set<Question> questions = questionsService.findByDifficultyAndCategory(userSelectionsView);

        if (questions == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/interview-questions/all")
    public ResponseEntity<Set<Question>> getAllQuestions() {
        Set<Question> questions = questionsService.getAllQuestions();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping(
            value = "/propose-question/proposed",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<HttpStatus> addProposedQuestion(@RequestBody ProposedQuestionDto dto) {
        if (questionsService.isProposedQuestionValid(dto)) {
            ProposedQuestion proposedQuestion = proposedQuestionMapper.toEntity(dto);
            return questionsService.saveProposedQuestion(proposedQuestion);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/propose-question/all")
    public ResponseEntity<ArrayList<ProposedQuestion>> getAllProposedQuestions() {
        ArrayList<ProposedQuestion> proposedQuestions = questionsService.getAllProposedQuestions();

        return new ResponseEntity<>(proposedQuestions, HttpStatus.OK);
    }
}
