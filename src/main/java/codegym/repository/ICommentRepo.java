package codegym.repository;

import codegym.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.ArrayList;

public interface ICommentRepo extends CrudRepository<Comment,Long> {
    @Query(value = "select * from Comment where comment_blog_id = :idBlog",nativeQuery = true)
   ArrayList<Comment> findCommentByIdBlog( @Param("idBlog") long idBlog);

}
