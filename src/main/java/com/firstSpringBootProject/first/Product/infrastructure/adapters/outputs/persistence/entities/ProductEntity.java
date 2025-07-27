package com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.entities.CategoryEntity;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    @Size(min = 4, max = 100)
    private String name;

    @Column(nullable = false, length = 100)
    @Size(min = 4, max = 100)
    private String code;

    @Column(nullable = true, length = 500)
    @Size(min = 4, max = 500)
    private String description;

    @Column(nullable = true, length = 500)
    @Size(min = 4, max = 500)
    private String urlImage;

    @Column(nullable = true)
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Float price;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;

    @ManyToOne
    private CategoryEntity category;


    public ProductEntity() {
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
