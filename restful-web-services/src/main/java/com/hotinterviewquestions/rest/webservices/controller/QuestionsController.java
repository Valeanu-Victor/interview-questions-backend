package com.hotinterviewquestions.rest.webservices.controller;

import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.dto.view.UserSelectionsView;
import com.hotinterviewquestions.rest.webservices.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping(
            value = "/interview-questions/all",
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

    @GetMapping("/interview-questions/aa")
    public ResponseEntity<Set<Question>> getAll() {
        Set<Question> questions = new HashSet<>();
        questions = questionsService.getAll();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
