package com.firstSpringBootProject.first.User.domain.models;


import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.User.domain.enums.UserType;

import java.time.LocalDateTime;
import java.util.List;

public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    private UserType userType;
    private String dateCreated;
    private String dateUpdated;
    private List<Product> products;

//    public User(Long id,String username, String firstName, String lastName, String email, String address, String cellphone, String password, UserType userType, String dateCreated, String dateUpdated) {
//        this.id = id;
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.address = address;
//        this.cellphone = cellphone;
//        this.password = password;
//        this.userType = userType;
//        this.dateCreated = dateCreated;
//        this.dateUpdated = dateUpdated;
//    }


    public User(Long id, String username, String firstName, String lastName, String email, String address, String cellphone, String password, UserType userType, String dateCreated, String dateUpdated, List<Product> products) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.cellphone = cellphone;
        this.password = password;
        this.userType = userType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

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

 /*   public void setPassword(String password) {
        this.password = password;
    }*/

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
