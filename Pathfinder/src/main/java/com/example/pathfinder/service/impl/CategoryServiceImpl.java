package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.CategoryEntity;
import com.example.pathfinder.model.entity.enums.CategoryNameEnum;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity getCategoryByCategoryEnum(CategoryNameEnum cat) {
        return  categoryRepository.findByName(cat).orElse(null);
    }
}
