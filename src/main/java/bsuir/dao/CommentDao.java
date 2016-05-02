package bsuir.dao;

import bsuir.model.Comment;

import java.util.List;

/**
 * Created by Ilya on 04.04.2016.
 */
public interface CommentDao {
    void add(Comment comment);
    List<Comment> getCommentsByMaterialId(Integer id);
}
