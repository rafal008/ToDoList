package com.projekt.todolist.service;

import com.projekt.todolist.dao.ToDoDataAccess;
import com.projekt.todolist.dao.UserDataAccess;
import com.projekt.todolist.domain.ToDo;
import com.projekt.todolist.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//klasa zajmujaca sie obsluga uzytkownikow
@Service
public class UserServiceImpl implements UserService {

    //obiekt zajmujący się obsluga bazy danych uzytkownikow
    @Autowired
    UserDataAccess userDAO;
    @Autowired
    ToDoDataAccess toDoDAO;


    public void registerNewUser(User user)
    {
        // userDAO zajmujacy sie dostepem do bazy danych, wprowadza nowego uzytkownika
        userDAO.addUser(user);
    }
    public User getLoggedUser(String login,String password)
    {
        return userDAO.checkUser(login,password);


    }


    public void addToDo(ToDo t) {
        toDoDAO.save(t);
    }
}
