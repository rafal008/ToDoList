package com.projekt.todolist.command;

import com.projekt.todolist.domain.User;

//Klasa reprezetujaca formularz rejestracyjny nowego użytkownika
public class RegCommand {

    // przy tworzeniu nowego uzytkownika podczas rejestracji jego dane beda wprowadzane do u
        User u;


        public User getU() {
            return u;
        }

        public void setU(User u) {
            this.u = u;
        }


}
