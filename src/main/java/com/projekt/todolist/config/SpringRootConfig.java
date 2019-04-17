package com.projekt.todolist.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

//Klasa potrzebna do skonfigurowania polaczenia z baza danych, wprowadzam login i haslo, nazwe bazy danych
@Configuration
public class SpringRootConfig {

    @Bean
    public BasicDataSource getBasicDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/todolist?useSSL=false&serverTimezone=Europe/Moscow");
        ds.setUsername("hbstudent");
        ds.setPassword("hbstudent");

        return ds;

    }


}
