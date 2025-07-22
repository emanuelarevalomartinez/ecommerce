package com.firstSpringBootProject.first.Category.domain.ports.in;

import com.firstSpringBootProject.first.Category.domain.models.Category;

import java.util.List;

public interface FindAllCategoriesPort
 {
     List<Category> findAll();
}
