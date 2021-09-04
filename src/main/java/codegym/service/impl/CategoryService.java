package codegym.service.impl;

import codegym.model.Category;
import codegym.repository.ICategoryRepo;
import codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Override
    public ArrayList<Category> findAll() {
        return (ArrayList<Category>) iCategoryRepo.findAll();
    }

    @Override
    public Category findByID(long id) {
        return iCategoryRepo.findById(id).get();
    }
}
