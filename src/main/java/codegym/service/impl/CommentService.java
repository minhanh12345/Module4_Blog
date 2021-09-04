package codegym.service.impl;

import codegym.model.Comment;
import codegym.repository.ICommentRepo;
import codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepo iCommentRepo;
    @Override
    public ArrayList<Comment> findAllByIdBlog(long idBlog) {
        return iCommentRepo.findCommentByIdBlog(idBlog);
    }
}
