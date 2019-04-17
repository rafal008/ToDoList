package com.projekt.todolist.dao;

import com.projekt.todolist.domain.User;

public interface UserDataAccess {
    public void addUser(User user);
    public User checkUser(String login,String password);


}
