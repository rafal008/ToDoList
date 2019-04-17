package com.projekt.todolist.domain;

public class ToDo {

    private Integer toDoId;
    private Integer userId;
    private String day;
    private String month;
    private String year;
    private String title;
    private String description;
    private String priority;
    private String done;

    public Integer getToDoId() {
        return toDoId;
    }

    public void setToDoId(Integer toDoId) {
        this.toDoId = toDoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    @Override
    public String toString()
    {
        return "ToDo{"+toDoId+","+userId+","+","+day+","+month+","+year+","+title+","+description+","+priority+"}";
    }
}
