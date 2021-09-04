package codegym.repository;

import codegym.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IBlogRepo extends CrudRepository<Blog, Long> {
    @Query(nativeQuery = true,value = "select * from Blog where blog_category_id = :idCate")
    ArrayList<Blog> findAllBlogByIdCate(@Param("idCate") long idCate);
}
