package codegym.service.impl;

import codegym.model.Blog;
import codegym.repository.IBlogRepo;
import codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    @Override
    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    @Override
    public ArrayList<Blog> findAll() {
        return (ArrayList<Blog>) iBlogRepo.findAll();
    }

    @Override
    public void delete(long id) {
        iBlogRepo.delete(findById(id));
    }

    @Override
    public Blog findById(long id) {
        return iBlogRepo.findById(id).get();
    }

    @Override
    public ArrayList<Blog> findAllBlogByIdCate(long id) {
        return iBlogRepo.findAllBlogByIdCate(id);
    }


}
