package com.hugo.quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alternative_table")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "alternativa")
    private String alternative;
    @Column(name = "ehCorreta")
    private Boolean itsCorrect;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_questao")
    private Question question;


    public Alternative() {

    }

    public Alternative(String alternative, Boolean itsCorrect) {
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
    }

    public Alternative(Long id, String alternative, Boolean itsCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
    }

    public Alternative(Long id, String alternative, Boolean itsCorrect, Question question) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }


    public Boolean getItsCorrect() {
        return itsCorrect;
    }

    public void setItsCorrect(Boolean correct) {
        itsCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    @Override
    public String toString() {
        return "Alternative: " +
                "---> id= " + id +
                "---> Alternative= " + alternative;
    }
}

