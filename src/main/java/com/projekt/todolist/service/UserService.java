package com.projekt.todolist.service;

import com.projekt.todolist.domain.ToDo;
import com.projekt.todolist.domain.User;

public interface UserService {

    public void registerNewUser(User user);
    public User getLoggedUser(String lohin,String password);
    public void addToDo(ToDo t);


}
