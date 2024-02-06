package com.hugo.quiz.dto;

public class GameplaySessionDTO {

    private PlayerDTO playerInSession;
    private QuizDTO quiz;

    public GameplaySessionDTO() {

    }

    public GameplaySessionDTO(PlayerDTO playerInSession, QuizDTO quiz) {
        this.playerInSession = playerInSession;
        this.quiz = quiz;
    }

    public PlayerDTO getPlayerInSession() {
        return playerInSession;
    }

    public void setPlayerInSession(PlayerDTO playerInSession) {
        this.playerInSession = playerInSession;
    }

    public QuizDTO getQuizDTO() {
        return quiz;
    }

    public void setQuizDTO(QuizDTO quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "GameplaySessionDTO{" +
                "quiz=" + quiz +
                "player=" + playerInSession +
                '}';
    }
}
