package codegym.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blog_id;
    private String blog_title;
    private String blog_content;
    private int blog_views;
    private int blog_like;
    @ManyToOne
    @JoinColumn(name = "blog_category_id")
    private Category blog_category;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Comment> blog_comments;

    public Blog() {
    }

    public Blog(long blog_id, String blog_title, String blog_content, int blog_views, int blog_like, Category blog_category, Set<Comment> blog_comments) {
        this.blog_id = blog_id;
        this.blog_title = blog_title;
        this.blog_content = blog_content;
        this.blog_views = blog_views;
        this.blog_like = blog_like;
        this.blog_category = blog_category;
        this.blog_comments = blog_comments;
    }

    public long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(long blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public int getBlog_views() {
        return blog_views;
    }

    public void setBlog_views(int blog_views) {
        this.blog_views = blog_views;
    }

    public int getBlog_like() {
        return blog_like;
    }

    public void setBlog_like(int blog_like) {
        this.blog_like = blog_like;
    }

    public Category getBlog_category() {
        return blog_category;
    }

    public void setBlog_category(Category blog_category) {
        this.blog_category = blog_category;
    }

    public Set<Comment> getBlog_comments() {
        return blog_comments;
    }

    public void setBlog_comments(Set<Comment> comments) {
        this.blog_comments = comments;
    }
}
