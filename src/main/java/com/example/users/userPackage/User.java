package com.example.users.userPackage;


public class User {
    private String id;
    private String name;
    private String dob;

    public User() {
    }

    public User(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
