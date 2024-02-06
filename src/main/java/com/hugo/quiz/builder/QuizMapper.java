package com.hugo.quiz.builder;

import com.hugo.quiz.dto.QuizDTO;
import com.hugo.quiz.model.Quiz;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuizMapper {

    private final ModelMapper modelMapper;

    public QuizMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuizDTO toDTO(Quiz model) {
        return modelMapper.map(model, QuizDTO.class);
    }

    public Quiz toEntity(QuizDTO dto) {
        return modelMapper.map(dto, Quiz.class);
    }

    public List<QuizDTO> toListDTO(List<Quiz> modelList) {
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Quiz> toList(List<QuizDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
