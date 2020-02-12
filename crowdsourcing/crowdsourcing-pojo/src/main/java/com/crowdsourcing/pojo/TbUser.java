package com.crowdsourcing.pojo;

import java.util.Date;

public class TbUser {
    private Long id;

    private String username;

    private String password;

    private String passwordSalt;

    private String email;

    private String role;

    private Boolean isLock;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer score;

    private Integer task1Quantity;

    private Integer task2Quantity;

    private Integer task3Quantity;

    private Integer task1DoubtfulQuantity;

    private Integer task2DoubtfulQuantity;

    private Integer task3DoubtfulQuantity;

    private Integer permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTask1Quantity() {
        return task1Quantity;
    }

    public void setTask1Quantity(Integer task1Quantity) {
        this.task1Quantity = task1Quantity;
    }

    public Integer getTask2Quantity() {
        return task2Quantity;
    }

    public void setTask2Quantity(Integer task2Quantity) {
        this.task2Quantity = task2Quantity;
    }

    public Integer getTask3Quantity() {
        return task3Quantity;
    }

    public void setTask3Quantity(Integer task3Quantity) {
        this.task3Quantity = task3Quantity;
    }

    public Integer getTask1DoubtfulQuantity() {
        return task1DoubtfulQuantity;
    }

    public void setTask1DoubtfulQuantity(Integer task1DoubtfulQuantity) {
        this.task1DoubtfulQuantity = task1DoubtfulQuantity;
    }

    public Integer getTask2DoubtfulQuantity() {
        return task2DoubtfulQuantity;
    }

    public void setTask2DoubtfulQuantity(Integer task2DoubtfulQuantity) {
        this.task2DoubtfulQuantity = task2DoubtfulQuantity;
    }

    public Integer getTask3DoubtfulQuantity() {
        return task3DoubtfulQuantity;
    }

    public void setTask3DoubtfulQuantity(Integer task3DoubtfulQuantity) {
        this.task3DoubtfulQuantity = task3DoubtfulQuantity;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}