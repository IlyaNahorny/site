package bsuir.dao;

import bsuir.model.User;

import java.util.List;

/**
 * Created by Ilya on 13.02.2016.
 */
public interface UserDao {

    List<User> getAllUsers();

    void add(User user);

    void remove(Integer userId);

    User findByUserName(String username);

    User findByUserId(Integer id);

    Boolean alreadyExist(String username);

    void updateImage(Integer id, String url);

    void updateContent(Integer id, User user);

    void banUser(Integer id);
}
