package com.example.shilpokalaac;

public class LoginController
{
    private String Name;
    private String Password;

    public LoginController(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "LoginController{" +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    @javafx.fxml.FXML
    public void initialize() {
    }}