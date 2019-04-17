package com.projekt.todolist.service;

import com.projekt.todolist.domain.ToDo;

import java.util.List;

public interface ToDoService {
    public List<ToDo> findAllUserTodos(Integer userId);
    public void deleteTask(Integer toDoId);
    public  ToDo findByTaskId(Integer toDoId);
    public void updateTask(ToDo task);

    public List<ToDo> findSelectedTasks(Integer userId,String text);

    public List<ToDo> findByPriority(Integer userId);

    public List<ToDo> findByTime(Integer userId);

    public List<ToDo> findByNotDone(Integer userId);
    public List<ToDo> findAfterTime(Integer userId);









}
