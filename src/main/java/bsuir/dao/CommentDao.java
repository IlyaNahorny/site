package bsuir.dao;

import bsuir.model.Comment;

import java.util.List;

/**
 * Created by Ilya on 04.04.2016.
 */
public interface CommentDao {
    void add(Comment comment);
    List<Comment> getCommentsByMaterialId(Integer id);
    List<Comment> getCommentsByUsername(String username);
    void updateUrl(Integer id ,String url);
    void updateLike(Integer id ,int value);
    Comment getCommentById(Integer id);
}
