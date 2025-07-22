package com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateCategoryDto {

    @NotBlank(message = "Category name is requerid")
    @NotNull(message = "Category name can not be null")
    @Size(min = 4, max = 100, message = "Category name must be between 4 and 100 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
