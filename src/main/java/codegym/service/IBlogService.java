package codegym.service;

import codegym.model.Blog;

import java.util.ArrayList;

public interface IBlogService {
    Blog save(Blog blog);
    ArrayList<Blog> findAll();
    void delete(long id);
    Blog findById(long id);
    ArrayList<Blog> findAllBlogByIdCate(long id);
}
