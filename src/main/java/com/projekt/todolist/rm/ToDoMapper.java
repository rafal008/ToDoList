package com.projekt.todolist.rm;

import com.projekt.todolist.domain.ToDo;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDoMapper implements RowMapper<ToDo> {

    @Override
    public ToDo mapRow(ResultSet rs, int i) throws SQLException
    {
        ToDo task=new ToDo();
        task.setToDoId(rs.getInt("toDoId"));
        task.setUserId(rs.getInt("userId"));
        task.setMonth(rs.getString("month"));
        task.setDay(rs.getString("day"));
        task.setYear(rs.getString("year"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setPriority(rs.getString("priority"));
        task.setDone(rs.getString("done"));
        return task;
    }
}
