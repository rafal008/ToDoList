package com.projekt.todolist.command;
// klasa reprezentujaca konkretne konto, potrzebna do weryfikacji logowania
public class Account {
    //
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
