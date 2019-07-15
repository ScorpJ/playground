package com.arthur.mybatisstartup.entity;

import java.time.LocalDate;

public class Task {
    private Integer taskId;

    private String title;

    private LocalDate startDate;

    private String dueDate;

    private Byte status;

    private Byte priority;

    private String description;

    public Task(Integer taskId, String title, LocalDate startDate, String dueDate, Byte status, Byte priority) {
        this.taskId = taskId;
        this.title = title;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
    }

    public Task(Integer taskId, String title, LocalDate startDate, String dueDate, Byte status, Byte priority, String description) {
        this.taskId = taskId;
        this.title = title;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }

    public Task() {
        super();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate == null ? null : dueDate.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}