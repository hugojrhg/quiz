package com.hugo.quiz.model;

import jakarta.persistence.OneToOne;

public class GameplaySession {

    @OneToOne
    private Player playerInSession;
    private Quiz quiz;

    public GameplaySession() {

    }

    public GameplaySession(Player playerInSession, Quiz quiz) {
        this.playerInSession = playerInSession;
        this.quiz = quiz;
    }

    public Player getPlayerInSession() {
        return playerInSession;
    }

    public void setPlayerInSession(Player playerInSession) {
        this.playerInSession = playerInSession;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
