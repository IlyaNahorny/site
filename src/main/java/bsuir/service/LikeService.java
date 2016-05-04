package bsuir.service;

import bsuir.model.Like;

import java.util.List;

/**
 * Created by Ilya on 03.05.2016.
 */
public interface LikeService {
    void addLike(Like like);
    void deleteLike(Like like);
    List<Like> getLikesByIdComment(Integer id_comment);
    Like checkLike(List<Like> likes ,String username);
    int numberOfLikes(List<Like> likes);
}
