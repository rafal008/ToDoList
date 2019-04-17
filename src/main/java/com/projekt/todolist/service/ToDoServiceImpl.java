package com.projekt.todolist.service;

import com.projekt.todolist.dao.ToDoDataAccess;
import com.projekt.todolist.dao.UserDataAccess;
import com.projekt.todolist.domain.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//klasa zajmujaca sie obsluga zadan
@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    UserDataAccess userDAO;
    @Autowired
    ToDoDataAccess toDoDAO;
    public List<ToDo> findAllUserTodos(Integer userId)
    {
        return toDoDAO.findAllByUserId(userId);
    }

    public void deleteTask(Integer toDoId)
    {
        toDoDAO.deleteToDo(toDoId);

    }

    public  ToDo findByTaskId(Integer toDoId)
    {
       return toDoDAO.getTask(toDoId);
    }
    public void updateTask(ToDo task)
    {
        toDoDAO.update(task);
    }
    public List<ToDo> findSelectedTasks(Integer userId,String text)
    {
        return toDoDAO.getSelectedTasks(userId,text);
    }

    public List<ToDo> findByPriority(Integer userId)
    {
        return toDoDAO.orderByPriority(userId);
    }
    public List<ToDo> findByTime(Integer userId)
    {
        return toDoDAO.orderByTime(userId);
    }
    public List<ToDo> findByNotDone(Integer userId)
    {
        return toDoDAO.orderByNotDone(userId);
    }

    public List<ToDo> findAfterTime(Integer userId)
    {
        return toDoDAO.getAfterTime(userId);
    }
}
