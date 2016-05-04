package bsuir.service;

import bsuir.model.Comment;

import java.util.List;

/**
 * Created by Ilya on 04.04.2016.
 */
public interface CommentService {
    void add(Comment comment);
    List<Comment> getCommentsByMaterialId(Integer id);
    int getAmountComments(Integer id);
    void updateUrlPictures(String username, String url);
    void updateLike(Integer id ,int value);
    Comment getCommentById(Integer id);
}
