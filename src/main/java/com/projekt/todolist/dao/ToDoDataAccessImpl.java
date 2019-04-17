package com.projekt.todolist.dao;

import com.projekt.todolist.domain.ToDo;
import com.projekt.todolist.rm.ToDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ToDoDataAccessImpl implements ToDoDataAccess {
    @Autowired
    private DataSource ds;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(DataSource ds) {

        namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(ds);
        jdbcTemplate=new JdbcTemplate(ds);
    }
    public void save(ToDo todo) {


        String sql = "INSERT INTO tasks1 (userId,month,day,year,title,description,priority,done) VALUES (:userId, :month, :day, :year, :title, :description, :priority,:done)";
        Map m = new HashMap();
        m.put("userId", todo.getUserId());
        m.put("month", todo.getMonth());
        m.put("day", todo.getDay());
        m.put("year", todo.getYear());
        m.put("title", todo.getTitle());
        m.put("description", todo.getDescription());
        m.put("priority", todo.getPriority());
        m.put("done", todo.getDone());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, ps, kh);
        Integer todoId = kh.getKey().intValue();
        todo.setToDoId(todoId);
}

    public List<ToDo> findAllByUserId(Integer userId)
    {
        String sql="Select * from tasks1 where userId=?";

        return jdbcTemplate.query(sql,new Object[]{userId},new ToDoMapper());
    }

    public void deleteToDo(Integer toDoId)
    {
        String sql="Delete from tasks1 where toDoId=?";
        jdbcTemplate.update(sql,toDoId);

    }
    public ToDo getTask(Integer toDoId)
    {
        String sql="Select * from tasks1 where toDoId=?";
        return jdbcTemplate.queryForObject(sql,new ToDoMapper(),new Object[]{toDoId});
    }

    @Override
    public void update(ToDo todo) {
        String sql = "UPDATE tasks1 SET month=:month, day=:day, year=:year, title=:title, description=:description, priority=:priority,done=:done  WHERE toDoId=:toDoId";
        Map m = new HashMap();
        m.put("toDoId", todo.getToDoId());
        m.put("month", todo.getMonth());
        m.put("day", todo.getDay());
        m.put("year", todo.getYear());
        m.put("title", todo.getTitle());
        m.put("description", todo.getDescription());
        m.put("priority", todo.getPriority());
        m.put("done", todo.getDone());

        namedParameterJdbcTemplate.update(sql, m);
    }

    public List<ToDo> getSelectedTasks(Integer userId,String text)
    {
        String sql="SELECT toDoId, userId, month, day, year, title, description, priority,done FROM tasks1 WHERE userId=? AND " +
                "(month LIKE '%" + text + "%' OR day LIKE '%" + text + "%' OR year LIKE '%" + text + "%' OR title LIKE '%" + text + "%' OR description LIKE '%" + text + "%' OR priority LIKE '%" + text + "%' OR done LIKE '%"+text+"%')";

        return jdbcTemplate.query(sql, new ToDoMapper(), userId);

    }
    public List<ToDo> orderByPriority(Integer userId)
    {
        String sql="Select * from tasks1 where userId=? order by priority";
        return jdbcTemplate.query(sql,new ToDoMapper(),userId);
    }

    public List<ToDo> orderByTime(Integer userId)
    {
        String sql="Select * from tasks1 where userId=? order by year,month,day ";
        return jdbcTemplate.query(sql,new ToDoMapper(),userId);
    }
    public List<ToDo> orderByNotDone(Integer userId)
    {
        String sql="select * from tasks1 where userId=? and done='No'";
        return jdbcTemplate.query(sql,new ToDoMapper(),userId);
    }

    public List<ToDo> getAfterTime(Integer userId)
    {
        String sql="Select * from tasks1 where userid=? and (cast(Year(curDate()) as signed) > cast(Year as signed) or (cast(Year(curDate()) as signed) = cast(Year as signed) and cast(month(curDate()) as signed) > cast(month as signed) ) " +
                "or (cast(Day(curDate()) as signed) > cast(Day as signed) and cast(Year(curDate()) as signed) = cast(Year as signed) and cast(month(curDate()) as signed) = cast(month as signed) ))";
        return jdbcTemplate.query(sql,new ToDoMapper(),userId);
    }
}

