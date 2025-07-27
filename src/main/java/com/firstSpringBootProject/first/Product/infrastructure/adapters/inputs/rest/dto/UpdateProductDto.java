package com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.dto;

import jakarta.validation.constraints.*;

public class UpdateProductDto {


    @NotBlank(message = "Product name is requerid")
    @NotNull(message = "Product name can not be null")
    @Size(min = 4, max = 100, message = "Product name must be between 4 and 100 characters")
    private String username;

    @NotBlank(message = "Product code is requerid")
    @NotNull(message = "Product code can not be null")
    @Size(min = 4, max = 100, message = "Product code must be between 4 and 100 characters")
    private String code;


    @Size(min = 4, max = 500, message = "Product description must be between 4 and 500 characters")
    private String description;

    @Size(min = 4, max = 500, message = "Product urlImage must be between 4 and 500 characters")
    private String urlImage;

    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "10000.00", inclusive = true)
    private Float price;

    @NotBlank(message = "User Id asociated to Product is requerid")
    @NotNull(message = "User Id to Product can not be null")
    private String userId;

    @NotBlank(message = "Category Id asociated to Product is requerid")
    @NotNull(message = "Category Id to Product can not be null")
    private String categoryId;


    private String dateUpdated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
