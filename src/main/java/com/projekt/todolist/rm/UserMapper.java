package com.projekt.todolist.rm;

import com.projekt.todolist.domain.User;
import com.sun.rowset.internal.Row;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>
{

    @Override
    public  User mapRow(ResultSet rs, int i) throws SQLException {
        User user=new User();
        user.setUserId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setPhone(rs.getString("phone"));
        user.setLogin(rs.getString("login"));

        return user;
    }
}
