package com.projekt.todolist.controller;


import com.projekt.todolist.domain.ToDo;
import com.projekt.todolist.service.ToDoService;
import com.projekt.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ToDoController {

    @Autowired
    private UserService userService;

    @Autowired
    private ToDoService todoservice;

    @RequestMapping(path="/saveTask")
    public String updateOrAddTask(@ModelAttribute("command")ToDo task, Model m, HttpSession session)
    {
        //
        Integer toDoId=(Integer) session.getAttribute("modificatedTask");

        if(toDoId==null) {
            Integer userId = (Integer) session.getAttribute("userId");
            task.setUserId(userId);
            userService.addToDo(task);


            return "redirect:todolist";
        }
        else{

            task.setToDoId(toDoId);

            todoservice.updateTask(task);
            return "redirect:todolist";
        }
    }
    @RequestMapping(path = {"/todolist"})
    public String showToDolist(Model m, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findAllUserTodos(userId));

        return "todolist";
    }
    @RequestMapping(path= "/del_todo")
    public String deleteTodoList(@RequestParam("toDoId") Integer todoId) {

        todoservice.deleteTask(todoId);
        return "redirect:todolist?act=del";
    }
    @RequestMapping(path = {"/edit_todo"})
    public String editToDo(Model m, HttpSession session, @RequestParam("toDoId") Integer toDoId) {

        session.setAttribute("modificatedTask", toDoId);
        ToDo task = todoservice.findByTaskId(toDoId);
        m.addAttribute("command", task);
        return "addTask";
    }
    @RequestMapping(path = {"/search"})
    public String searchToDo(Model m, HttpSession session, @RequestParam("freetext") String freetext) {

        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findSelectedTasks(userId, freetext));
        return "todolist";
    }
    @RequestMapping(path = {"/priority"})
    public String tasksByPriority(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findByPriority(userId));
        return "viewTaskByPriority";
    }
    @RequestMapping(path="/time")
    public String tasksByTime(Model m,HttpSession session)
    {
        Integer userId=(Integer) session.getAttribute("userId");
        m.addAttribute("todolists",todoservice.findByTime(userId));
        return "viewTaskByTime";
    }
    @RequestMapping(path="/not_done")
    public String tasksByNotDone(Model m,HttpSession session)
    {
        Integer userId=(Integer) session.getAttribute("userId");
        m.addAttribute("todolists",todoservice.findByNotDone(userId));
        return "tasksByNotDone";
    }
    @RequestMapping(path="/after_time")
    public String tasksAfterTime(Model m,HttpSession session)
    {
        Integer userId=(Integer) session.getAttribute("userId");
        m.addAttribute("todolists",todoservice.findAfterTime(userId));
        return "tasksByNotDone";
    }


}
