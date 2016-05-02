package bsuir.service;

import bsuir.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bsuir.dao.CommentDao;
import bsuir.model.Comment;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Ilya on 04.04.2016.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    public int getAmountComments(Integer id) {
        List<Comment> comments = commentDao.getCommentsByMaterialId(id);
        return comments.size();
    }

    public void add(Comment comment) {
        commentDao.add(comment);
    }

    public List<Comment> getCommentsByMaterialId(Integer id) {
        return commentDao.getCommentsByMaterialId(id);
    }
}
