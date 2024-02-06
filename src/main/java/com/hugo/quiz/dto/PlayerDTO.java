package com.hugo.quiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class PlayerDTO {

    private Long id;
    @NotNull
    @JsonProperty("nickname")
    private String nickName;
    private Integer score;
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDTO userDTO;

    public PlayerDTO() {

    }

    public PlayerDTO(String nickName, UserDTO userDTO) {
        this.nickName = nickName;
        this.userDTO = userDTO;
    }

    public PlayerDTO(Long id, String nickName, Integer score, UserDTO userDTO) {
        this.id = id;
        this.nickName = nickName;
        this.score = score;
        this.userDTO = userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score){this.score = score;}

    public void increaseScore() {
        this.score++;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "\n\nPlayerDTO - id: " + id +
                "\nNickName='" + nickName +
                "\nScore=" + score;
    }


}
