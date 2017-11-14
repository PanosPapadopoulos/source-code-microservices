package cs.unipi.zuulkeepergateway.models;


import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;

    private String firstName;

    private String surName;

    private String role;

    private String email;

    private String password;

    private boolean active;

    public User(String firstName, String surName, String role, String email, String password, boolean active) {
        this.firstName = firstName;
        this.surName = surName;
        this.role = role;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}