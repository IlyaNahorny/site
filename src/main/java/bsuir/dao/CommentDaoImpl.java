package bsuir.dao;

import org.springframework.stereotype.Repository;
import bsuir.model.Comment;
import bsuir.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
