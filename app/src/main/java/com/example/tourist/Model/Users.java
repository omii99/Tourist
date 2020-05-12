package com.example.tourist.Model;

public class Users {
    private String Name;
    private String Password;
    private  String Email;

    public Users() {}
    public Users(String name, String password, String email) {
        Name = name;
        Password = password;
        Email = email;
    }

    public String getName() {return Name;}
    public void setName(String name) {Name = name;}
    public String getPassword() {return Password; }
    public void setPassword(String password) {Password = password;}
    public String getEmail() {return Email;}
    public void setEmail(String email) {Email = email;}



}
