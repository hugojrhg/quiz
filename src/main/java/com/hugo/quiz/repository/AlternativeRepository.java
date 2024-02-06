package com.hugo.quiz.repository;

import com.hugo.quiz.model.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    List<Alternative> findByQuestionId(Long questionId);
    Optional<Alternative> findQuestionById(Long id);
    Optional<Alternative> findByQuestionIdAndItsCorrect(Long id, Boolean itsCorrect);

}
