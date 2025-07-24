package com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.Category.application.usecases.*;
import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.dto.CreateCategoryDto;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.dto.UpdateCategoryDto;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.mappers.CategoryRestMapper;
import com.firstSpringBootProject.first.shared.ApiResponse.ApiResponse;
import com.firstSpringBootProject.first.shared.ApiResponse.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryRestMapper categoryRestMapper;

    @Autowired
    private CreateCategoryUseCase createCategoryUseCase;

    @Autowired
    private FindAllCategoriesUseCase findAllCategoriesUseCase;

    @Autowired
    private FindCategoryByIdUsecase findCategoryByIdUsecase;

    @Autowired
    private UpdateCategoryByIdUseCase updateCategoryByIdUseCase;

    @Autowired
    private DeleteCategoryUseCase deleteCategoryUseCase;


    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto) {

        Category newCategory = categoryRestMapper.createCategoryFromDtoToDomainCategory(createCategoryDto);

        Category savedCategory = this.createCategoryUseCase.save(newCategory);

        return ResponseHandler.generateResponse(
                HttpStatus.CREATED,
                null,
                "Successfully created category",
                savedCategory
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> findAll(){

        List<Category> allCategories = this.findAllCategoriesUseCase.findAll();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                allCategories
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> findCategoryById(@PathVariable Long id){

        Category findCategoryById = this.findCategoryByIdUsecase.findById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                findCategoryById
        );

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryDto updateCategoryDto){

        Category updateCategory = categoryRestMapper.updateCategoryFromDtoToDomainCategory(updateCategoryDto);

        Category savedUpdateCategory = this.updateCategoryByIdUseCase.update(id, updateCategory);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "Successfully update category",
                savedUpdateCategory
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteCategoryById(@PathVariable Long id){

        this.deleteCategoryUseCase.deleteById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "Category successfully deleted",
                null
        );

    }




}
