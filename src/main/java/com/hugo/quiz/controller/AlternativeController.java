package com.hugo.quiz.controller;

import com.hugo.quiz.dto.AlternativeDTO;
import com.hugo.quiz.service.AlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternative")
public class AlternativeController {

    @Autowired
    private AlternativeService alternativeService;


    @GetMapping
    public List<AlternativeDTO> findAllQuestionsAlternatives() {
        return alternativeService.findAll();
    }

    @GetMapping("/{id}")
    public AlternativeDTO findById(@PathVariable Long id){
        return alternativeService.findById(id);
    }

    @PostMapping("/save")
    public AlternativeDTO save(@RequestBody AlternativeDTO alternativeDTO){
        return alternativeService.save(alternativeDTO);
    }

    @GetMapping("/question-id/{id}")
    public List<AlternativeDTO> findQuestionAlternativesByQuestionId(@PathVariable Long id){
        return alternativeService.findByQuestionId(id);
    }

}