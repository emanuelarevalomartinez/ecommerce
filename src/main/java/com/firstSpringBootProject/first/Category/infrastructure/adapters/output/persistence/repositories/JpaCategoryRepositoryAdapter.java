package com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;
import com.firstSpringBootProject.first.Category.domain.exceptions.ErrorCategoryMessageCode;
import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.entities.CategoryEntity;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.mappers.CategoryPersistenceMapper;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {

    @Autowired
    private JpaCategoryRepository categoryPersistence;

    @Autowired
    private CategoryPersistenceMapper categoryMapper;


    @Override
    public Category save(Category category) {

        if(this.findByName(category.getName()).isPresent()){

            System.out.println("error del nombre");
            System.out.println(category.getName());

            throw new CategoryDomainException(
                    ErrorCategoryMessageCode.CATEGORY_NAME_CONFLICT.getStatus(),
                    ErrorCategoryMessageCode.CATEGORY_NAME_CONFLICT.getType(),
                    String.format(ErrorCategoryMessageCode.CATEGORY_NAME_CONFLICT.getMessage() + category.getName()),
                    null
            );


        }

        CategoryEntity categoryEntity = categoryPersistence.save(categoryMapper.toCategoryEntity(category));

        return categoryMapper.toCategory(categoryEntity);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.toCategories(categoryPersistence.findAll());
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryPersistence.findById(id)
                .map(categoryMapper::toCategory);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryPersistence.findByName(name)
                .map(categoryMapper::toCategory);
    }


    @Override
    public Category update(Long id, Category category) {

        CategoryEntity existingCategoryEntity = categoryPersistence.findById(id)
                .orElseThrow(
                        () -> new CategoryDomainException(
                                ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getStatus(),
                                ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getType(),
                                String.format(ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getMessage() + id),
                                null
                        )
                );


        if(category.getName() != null){
            existingCategoryEntity.setName(category.getName());
        }

        // TODO tengo que ver como hacer que el tipo de retorno no de error a la hora de convertir los datos
//        if(category.getDateUpdated() != null){
//            existingCategoryEntity.setDateUpdated(category.getDateUpdated());
//        }

        CategoryEntity updateCategoryEntity = categoryPersistence.save(existingCategoryEntity);
        return categoryMapper.toCategory(updateCategoryEntity);

    }

    @Override
    public boolean deleteById(Long id) {

        Optional<Category> existingCategory = this.findById(id);

        if(existingCategory.isPresent()){
            categoryPersistence.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
