package com.projekt.todolist.dao;

import com.projekt.todolist.domain.User;
import com.projekt.todolist.rm.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDataAccessImpl implements UserDataAccess {
    @Autowired
    private DataSource ds;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(DataSource ds) {

        namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(ds);
        jdbcTemplate=new JdbcTemplate(ds);
    }

    public void addUser(User user)
    {
        String sql="Insert into users (name,surname,phone,login,password)"
                +"Values (:name,:surname,:phone,:login,:password)";   // polecenie wstwiajace nowego uzytkownika do bazy
        Map m=new HashMap();  // hash mapa zawierajaca nazwy parametrow(key) i ich wartosci(value)
        m.put("name", user.getName());
        m.put("surname", user.getSurname());
        m.put("phone", user.getPhone());
        m.put("login", user.getLogin());
        m.put("password", user.getPassword());

        KeyHolder kh = new GeneratedKeyHolder();  // obiekt ten bedzie nam zwracal klucz autoinkrementowany, w tym przypadku po dodaniu uzytkownika

        SqlParameterSource parameterSource = new MapSqlParameterSource(m);  //nasza mape wysylam do zrodla parametrow
        //obiekt odpowiada za wykonanie polecenia
        namedParameterJdbcTemplate.update(sql,parameterSource,kh);  //

        Integer userId = kh.getKey().intValue();  // wyciagam wartosc klucza

        user.setUserId(userId);  // ustawiam ja dla uzytkownika

    }
    //metoda sprawdzajaca czy istnieje dany user
    public User checkUser(String login,String password)
    {
        String sql="Select * from users where login= ? and password= ?";  // polecenie sprawdzajace czy istnieje danu user

        try {
            // tworzony jest obiekt User w przypadku istnienia danego uzytkownika
            User user = jdbcTemplate.queryForObject(sql,new Object[]{login, password} , new UserMapper());
            return user;
        }
        catch(EmptyResultDataAccessException ex)
        {
            // w przypadku braku wyniku sqlowego polecenia, zwracany jest null
            return null;
        }


    }
}
