package com.hugo.quiz.builder;

import com.hugo.quiz.dto.AlternativeDTO;
import com.hugo.quiz.model.Alternative;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlternativeMapper {

    private final ModelMapper modelMapper;

    public AlternativeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AlternativeDTO toDTO(Alternative model) {
        return modelMapper.map(model, AlternativeDTO.class);
    }

    public Alternative toEntity(AlternativeDTO dto) {
        return modelMapper.map(dto, Alternative.class);
    }


    public ArrayList<AlternativeDTO> toListDTO(List<Alternative> modelList) {
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Alternative> toList(List<AlternativeDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
