package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.CategoryRepository;
import com.SDS.Erasmus.domain.Category;
import com.SDS.Erasmus.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceJpa implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> listAll(){
        return categoryRepo.findAll();
    }
}
