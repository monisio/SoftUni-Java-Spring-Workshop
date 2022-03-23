package com.example.pathfinder.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UserRegisterBindingModel {


    @NotBlank(message = "Username is required!")
    private String username;
    @NotBlank(message = "Name is required!")
    private String fullName;
    @Email(message = "Please enter a valid email address!")
    private String email;
    @Positive(message = "Age should be an positive number!" )
    @Min(value = 10 ,message = "Invalid age!")
    private Integer age;
    @NotBlank(message = "Password is required!")
    private String password;
    @NotBlank(message = "Confirmation password is required!")
    private String confirmPassword;


    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
