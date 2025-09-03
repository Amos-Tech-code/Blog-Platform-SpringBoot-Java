package com.amos_tech_code.Blog.services;

import com.amos_tech_code.Blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;


public interface CategoryService {

    List<Category> listCategories();

    Category createCategory(Category category);

    void deleteCategory(UUID id);
}
