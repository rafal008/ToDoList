package com.projekt.todolist.controller;

import com.projekt.todolist.command.Account;

import com.projekt.todolist.command.RegCommand;
import com.projekt.todolist.domain.ToDo;
import com.projekt.todolist.domain.User;
import com.projekt.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@Controller
public class UserController {
    //user service odpowiada za obsluge klienta, np sprawdzanie podczas logowania czy istnieje dana osoba
    @Autowired
    private UserService userService;




    @RequestMapping(path= "/")
    public String main()
    {

        return "redirect:regform";
    }




    @RequestMapping(path="/regform")
    public String registerForm(Model m)
    {

        RegCommand cmd = new RegCommand();

        m.addAttribute("command",cmd);
        return "register";
    }



    @RequestMapping(path="/registerUser")
    public String registerUserInTheBase(@ModelAttribute("command") RegCommand m)
    {

        User newUser=m.getU();

        userService.registerNewUser(newUser);
        return "redirect:loginform";

    }



    @RequestMapping(path="/loginform")
    public String loginForm(Model m) {
        Account cmd = new Account();
        m.addAttribute("command", cmd);
        return "login";
    }


    @RequestMapping(path="/logUser")
    public String logUser(@ModelAttribute("command") Account a, HttpSession session) {


        User user = userService.getLoggedUser(a.getLogin(), a.getPassword());

        if (user == null) {

            return "login";

        } else {

            addUserInSession(user, session);
            return "redirect:addTask";
        }
    }


    @RequestMapping(path = "/addTask")
    public String addTask(Model m) {
        ToDo todo = new ToDo();
        m.addAttribute("command", todo);

        return "addTask";
    }



    private void addUserInSession(User user,HttpSession session)
        {
            session.setAttribute("user",user);

            session.setAttribute("userId",user.getUserId());
        }




        @RequestMapping(path="/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();
        return "redirect:loginform";
    }



    }










