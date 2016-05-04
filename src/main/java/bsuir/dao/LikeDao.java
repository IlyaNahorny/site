package bsuir.dao;

import bsuir.model.Like;

import java.util.List;

/**
 * Created by Ilya on 03.05.2016.
 */
public interface LikeDao {
    void addLike(Like like);
    void deleteLike(Like like);
    List<Like> getLikesByIdComment(Integer id_comment);
    Like checkLike(List<Like> likes ,String username);
    int numberOfLikes(List<Like> likes);
}
