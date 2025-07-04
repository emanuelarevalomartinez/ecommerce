package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto;

import com.firstSpringBootProject.first.User.domain.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserDto {

    @NotBlank(message = "User name is requerid")
    @NotNull(message = "User name can not be null")
    @Size(min = 4, max = 100, message = "User name must be between 4 and 100 characters")
    private String username;

    @NotBlank(message = "User firstName is requerid")
    @NotNull(message = "User firstName can not be null")
    @Size(min = 4, max = 100, message = "User firstName must be between 4 and 100 characters")
    private String firstName;

    @NotBlank(message = "User lastName is requerid")
    @NotNull(message = "User lastName can not be null")
    @Size(min = 4, max = 100, message = "User lastName must be between 4 and 100 characters")
    private String lastName;

    @NotBlank(message = "User email is requerid")
    @NotNull(message = "User email can not be null")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    @Email(message = "User lastName must be a valid email")
    private String email;

    @NotBlank(message = "User address is requerid")
    @NotNull(message = "User address can not be null")
    @Size(min = 5, max = 500, message = "User address must be between 5 and 500 characters")
    private String address;

    @NotBlank(message = "User cellphone is requerid")
    @NotNull(message = "User cellphone can not be null")
    @Size(min = 8, max = 20, message = "User cellphone must be between 8 and 20 characters")
    private String cellphone;

    @NotBlank(message = "User password is requerid")
    @NotNull(message = "User password can not be null")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;

    @NotNull(message = "User type is required")
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
