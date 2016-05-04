package bsuir.dao;

import bsuir.model.Like;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Repository
public class LikeDaoImpl implements LikeDao {

    @PersistenceContext
    EntityManager entityManager;

    public void addLike(Like like) {
        entityManager.persist(like);
    }

    public void deleteLike(Like like) {
//        entityManager.remove(like);
        entityManager.remove(entityManager.contains(like) ? like : entityManager.merge(like));
    }

    public List<Like> getLikesByIdComment(Integer comment_id) {
        List<Like> likes;
        try{
            likes = entityManager.createQuery("SELECT l FROM Like l WHERE l.comment_id = :comment_id",Like.class)
                    .setParameter("comment_id", comment_id).getResultList();
        }catch (NoResultException e){
            likes = null;
        }
        return likes;
    }

    public Like checkLike(List<Like> likes,String username) {
        Like likeExist = null;
        if(likes != null){
            Iterator iterator = likes.iterator();
            while(iterator.hasNext()){
                Like like = (Like)iterator.next();
                if(like.getUserName().equals(username)){
                    likeExist = like;
                }
            }
        }
        return likeExist;
    }

    public int numberOfLikes(List<Like> likes) {
        return likes.size();
    }


}
