package com.hugo.quiz.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quiz_table")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Player> players;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Question> questions;
    private String theme;

    public Quiz() {

    }

    public Quiz(Long id,String name, List<Player> players, List<Question> questions, String theme) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.questions = questions;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        for (Player player:players){
            player.setQuiz(this);
        }
        this.players = players;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        for (Question question:questions){
            question.setQuiz(this);
        }
        this.questions = questions;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                "name=" + name +
                ", players=" + players +
                ", questions=" + questions +
                ", theme='" + theme + '\'' +
                '}';
    }
}
