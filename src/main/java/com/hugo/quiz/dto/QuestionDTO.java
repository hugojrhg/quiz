package com.hugo.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("theme")
    private String theme;
    @JsonProperty("question")
    private String question;
    @JsonProperty("alternativeList")
    private ArrayList<AlternativeDTO> alternativeList = new ArrayList<>();

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String theme, String question, ArrayList<AlternativeDTO> alternativeList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.alternativeList = alternativeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<AlternativeDTO> getAlternativeList() {
        return alternativeList;
    }

    public void setAlternativeList(ArrayList<AlternativeDTO> alternativeList) {
        this.alternativeList = alternativeList;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", alternativeList=" + alternativeList +
                '}';
    }
}
