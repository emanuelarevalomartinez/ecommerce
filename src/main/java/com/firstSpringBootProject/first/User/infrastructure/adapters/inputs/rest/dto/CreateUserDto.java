package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto;

import com.firstSpringBootProject.first.User.domain.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserDto {

    @NotBlank(message = "User name is requerid")
    @NotNull(message = "User name can not be null")
    private String username;

    @NotBlank()
    private String firstName;

    @NotBlank()
    private String lastName;

    @NotBlank()
    private String email;

    @NotBlank()
    private String address;

    @NotBlank()
    private String cellphone;

    @NotBlank()
    private String password;

    @NotNull()
    private UserType userType;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
