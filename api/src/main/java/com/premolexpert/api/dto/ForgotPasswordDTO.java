package com.premolexpert.api.dto;

public class ForgotPasswordDTO {
    private String login;

    public ForgotPasswordDTO() {}

    public ForgotPasswordDTO(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

