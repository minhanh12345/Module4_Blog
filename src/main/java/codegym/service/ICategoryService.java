package codegym.service;

import codegym.model.Category;

import java.util.ArrayList;

public interface ICategoryService {
    ArrayList<Category> findAll();
    Category findByID(long id);
}
