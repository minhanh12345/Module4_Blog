package codegym.controller;

import codegym.model.Blog;
import codegym.model.Category;
import codegym.model.Comment;
import codegym.service.IBlogService;
import codegym.service.impl.BlogService;
import codegym.service.impl.CategoryService;
import codegym.service.impl.CommentService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller

public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/allBlog")
    public ResponseEntity<ArrayList<Blog>> findAllBlog() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBlog{idBlog}")
    public ResponseEntity deleteblog(@PathVariable(name = "idBlog") long id) {
        blogService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/saveBlog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }
    @PutMapping("/editBlog{idBlog}")
    public ResponseEntity<Blog> editBlog(@RequestBody Blog blog,@PathVariable(name = "idBlog") long id){
        Blog blog1=blogService.findById(id);
        blog.setBlog_id(blog1.getBlog_id());
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
    }

    @GetMapping("/allCategory")
    public ResponseEntity<ArrayList<Category>> findAllCate() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/allBlogByCate{idCate}")
    public ResponseEntity<ArrayList<Blog>> findAllBlogbByCate(@PathVariable(name = "idCate") long idCate) {
        return new ResponseEntity<>(blogService.findAllBlogByIdCate(idCate), HttpStatus.OK);
    }

    @GetMapping("/detailBlog{idBlog}")
    public ResponseEntity<Blog> detailBlog(@PathVariable(name = "idBlog") long id) {
        increaseViewByBlog(id);
        return new ResponseEntity(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/allCommentByIdBlog{idBlog}")
    public ResponseEntity<ArrayList<Comment>> findAllCommentByIdBlog(@PathVariable(name = "idBlog") long idBlog) {
        return new ResponseEntity<>(commentService.findAllByIdBlog(idBlog), HttpStatus.OK);
    }
    @PutMapping("increaseLike{idBlog}")
    public ResponseEntity<Blog> increaseLikeByBlog (@PathVariable(name = "idBlog") long idBlog){
        Blog blog=blogService.findById(idBlog);
        blog.setBlog_like(blog.getBlog_like()+1);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @PutMapping("increaseView{idBlog}")
    public ResponseEntity<Blog> increaseViewByBlog (@PathVariable(name = "idBlog") long idBlog){
        Blog blog=blogService.findById(idBlog);
        blog.setBlog_views(blog.getBlog_views()+1);
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
