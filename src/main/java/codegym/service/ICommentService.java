package codegym.service;

import codegym.model.Comment;

import java.util.ArrayList;

public interface ICommentService {
    ArrayList<Comment> findAllByIdBlog(long idBlog);
}
