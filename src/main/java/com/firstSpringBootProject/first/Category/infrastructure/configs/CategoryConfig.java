package com.firstSpringBootProject.first.Category.infrastructure.configs;


import com.firstSpringBootProject.first.Category.application.usecases.*;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        return new CreateCategoryUseCase(categoryRepositoryPort);
    }

    @Bean
    public FindAllCategoriesUseCase findAllCategoriesUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        return new FindAllCategoriesUseCase(categoryRepositoryPort);
    }


    @Bean
    public FindCategoryByIdUsecase findCategoryByIdUsecase(CategoryRepositoryPort categoryRepositoryPort) {
        return new FindCategoryByIdUsecase(categoryRepositoryPort);
    }


    @Bean
    public UpdateCategoryByIdUseCase updateCategoryByIdUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        return new UpdateCategoryByIdUseCase(categoryRepositoryPort);
    }

    @Bean
    public DeleteCategoryUseCase deleteCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        return new DeleteCategoryUseCase(categoryRepositoryPort);
    }

}
