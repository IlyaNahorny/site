package bsuir.service;


import bsuir.dao.LikeDao;
import bsuir.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;

    public void addLike(Like like) {
        likeDao.addLike(like);
    }

    public void deleteLike(Like like) {
        likeDao.deleteLike(like);
    }

    public List<Like> getLikesByIdComment(Integer id_comment) {
        return likeDao.getLikesByIdComment(id_comment);
    }

    public Like checkLike(List<Like> likes, String username) {
        return likeDao.checkLike(likes, username);
    }

    public int numberOfLikes(List<Like> likes) {
        return likeDao.numberOfLikes(likes);
    }
}
