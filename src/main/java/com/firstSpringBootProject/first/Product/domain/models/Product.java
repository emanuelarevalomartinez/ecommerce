package com.firstSpringBootProject.first.Product.domain.models;

public class Product {

    private Long id;
    private String name;
    private String code;
    private String description;
    private String urlImage;
    private Float price;
    private String dateCreated;
    private String dateUpdated;
    private Long userId;
    private Long categoryId;

    public Product() {
    }

    public Product(Long id, String name, String code, String description, String urlImage, Float price, String dateCreated, String dateUpdated, Long userId, Long categoryId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.urlImage = urlImage;
        this.price = price;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Product(String name, String code, String description, String urlImage, Float price, Long userId, Long categoryId) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.urlImage = urlImage;
        this.price = price;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
