package com.example.shilpokalaac;

import java.time.LocalDate;

public class User {
    private String name, email, role, password, gender;
    private LocalDate Dob;
    @javafx.fxml.FXML
    private TextArea outputTA;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox roleCB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private RadioButton femaleRB;

    public User(String name, String email, String role, String password, String gender, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.gender = gender;
        Dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", Dob=" + Dob +
                '}';
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) {
    }
}