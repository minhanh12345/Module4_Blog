package codegym.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;
    private String comment_content;
    @ManyToOne
    @JoinColumn(name = "comment_blog_id")
    private Blog comment_blog;

    public Comment() {
    }

    public Comment(long comment_id, String comment_content, Blog comment_blog) {
        this.comment_id = comment_id;
        this.comment_content = comment_content;
        this.comment_blog = comment_blog;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Blog getComment_blog() {
        return comment_blog;
    }

    public void setComment_blog(Blog comment_blog) {
        this.comment_blog = comment_blog;
    }
}
