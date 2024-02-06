package com.hugo.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternativeDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("alternative")
    private String alternative;

    @JsonProperty("itsCorrect")
    private Boolean itsCorrect;

    public AlternativeDTO() {
    }

    public AlternativeDTO(Long id, String alternative, Boolean itsCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
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

    public void setItsCorrect(Boolean itsCorrect) {
        this.itsCorrect = itsCorrect;
    }

    @Override
    public String toString() {
        return "Alternative: " +
                "---> id= " + id +
                "---> isCorrect= " + itsCorrect +
                "---> Alternative= " + alternative;
    }

}
