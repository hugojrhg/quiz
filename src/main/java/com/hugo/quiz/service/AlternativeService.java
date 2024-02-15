package com.hugo.quiz.service;

import com.hugo.quiz.builder.AlternativeMapper;
import com.hugo.quiz.dto.AlternativeDTO;
import com.hugo.quiz.exception.alternative.AlternativeNotFoundException;
import com.hugo.quiz.model.Alternative;
import com.hugo.quiz.repository.AlternativeRepository;
import com.hugo.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlternativeService {
    @Autowired
    private AlternativeRepository alternativeRepository;

    @Autowired
    private AlternativeMapper alternativeMapper;

    @Autowired
    private QuestionRepository questionRepository;


    public List<AlternativeDTO> findAll() {
        return alternativeMapper.toListDTO(alternativeRepository.findAll());
    }

    public AlternativeDTO findById(Long id) {
        Alternative alternative = alternativeRepository.findById(id).orElseThrow(AlternativeNotFoundException::new);
        return (alternative != null) ? (alternativeMapper.toDTO(alternative)) : (null);
    }

    public List<AlternativeDTO> findByIds(List<Long> ids) {
        try {
            List<Alternative> alternatives = alternativeRepository.findAllById(ids);
            return alternativeMapper.toListDTO(alternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("findByIds"), e);
        }
    }

    public AlternativeDTO save(AlternativeDTO alternativeDTO) {

        return alternativeMapper.toDTO(alternativeRepository.save(alternativeMapper.toEntity(alternativeDTO)));

    }

    public List<AlternativeDTO> findByQuestionId(Long questionId) {
        List<Alternative> alternativeList = alternativeRepository.findByQuestionId(questionId);
        return alternativeMapper.toListDTO(alternativeList);
    }

    public AlternativeDTO findByQuestionIdAndItsCorrect(Long questionId, Boolean alternativeStatus) {
        Alternative alternative = alternativeRepository.findByQuestionIdAndItsCorrect(questionId, alternativeStatus)
                .orElseThrow(() ->
                        new NoSuchElementException(msgError("findByQuestionIdAndItsCorrect")));
        return alternativeMapper.toDTO(alternative);
    }

    private String msgError(String method) {
        return "Ocorreu um erro em AlternativeService ao tentar fazer a operação no método: " + method;
    }

    private String msgQuestionIdNotPresent(String status) {
        return "O id da questão não foi encontrada ou é inválida é necessário preencher o valor questionId com um id válido! Status error: " + status;
    }


}
