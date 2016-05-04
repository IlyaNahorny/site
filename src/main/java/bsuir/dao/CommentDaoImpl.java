package bsuir.dao;

import org.springframework.stereotype.Repository;
import bsuir.model.Comment;
import bsuir.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ilya on 04.04.2016.
 */
@Repository
public class CommentDaoImpl implements CommentDao{

    @PersistenceContext
    EntityManager entityManager;

    public void add(Comment comment) {
        entityManager.persist(comment);
    }

    public List<Comment> getCommentsByMaterialId(Integer id) {
        List<Comment> comments = entityManager.find(Material.class,id).getComments();
        return comments;
    }

    public List<Comment> getCommentsByUsername(String username) {
        List<Comment> comments = null;
        comments = entityManager.createQuery("SELECT u FROM Comment u WHERE u.username = :name",Comment.class)
                .setParameter("name", username).getResultList();
        return comments;
    }

    public void updateUrl(Integer id, String url) {
        Comment comment = entityManager.getReference(Comment.class,id);
        comment.setUrl(url);
    }

    public void updateLike(Integer id, int value) {
        Comment comment = entityManager.getReference(Comment.class,id);
        comment.setKol_like(value);
    }

    public Comment getCommentById(Integer id) {
        return entityManager.find(Comment.class, id);
    }
}
