package com.amos_tech_code.Blog.services.impl;

import com.amos_tech_code.Blog.domain.entities.Category;
import com.amos_tech_code.Blog.repositories.CategoryRepository;
import com.amos_tech_code.Blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if (categoryRepository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category already exists with name: "+ categoryName);
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalStateException("Category has post associated with it.");
            }

            categoryRepository.deleteById(id);
        }
    }
}
