package com.hugo.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizDTO {

    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("questions")
    private List<QuestionDTO> questions;
    @JsonProperty("players")
    private List<PlayerDTO> players;
    @JsonProperty("theme")
    private String theme;

    public QuizDTO() {

    }

    public QuizDTO(Long id, String name, List<QuestionDTO> questions, List<PlayerDTO> players, String theme) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.players = players;
        this.theme = theme;
    }

    public QuizDTO(String name, List<QuestionDTO> questions, List<PlayerDTO> players, String theme) {
        this.name = name;
        this.questions = questions;
        this.players = players;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void addPlayerInQuiz(PlayerDTO playerDTO){
        this.players.add(playerDTO);
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "name='" + name + '\'' +
                ", questions=" + questions +
                ", players=" + players +
                ", theme='" + theme + '\'' +
                '}';
    }
}
