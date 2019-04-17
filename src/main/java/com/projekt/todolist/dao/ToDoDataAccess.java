package com.projekt.todolist.dao;

import com.projekt.todolist.domain.ToDo;

import java.util.List;

public interface ToDoDataAccess {

    public void save(ToDo todo);

    public List<ToDo> findAllByUserId(Integer userId);

    public void deleteToDo(Integer toDoId);

    public ToDo getTask(Integer toDoId);

    public void update(ToDo task);
    public List<ToDo> getSelectedTasks(Integer userId,String text);

    public List<ToDo> orderByPriority(Integer userId);

    public List<ToDo> orderByTime(Integer userId);

    public List<ToDo> orderByNotDone(Integer userId);

    public List<ToDo> getAfterTime(Integer userId);


}
