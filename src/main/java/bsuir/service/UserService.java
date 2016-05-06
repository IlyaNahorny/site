package bsuir.service;


import bsuir.model.User;

import java.util.List;

/**
 * Created by Ilya on 13.02.2016.
 */
public interface UserService {
    void add(User user);

    List<User> getAllUsers();

    User findByUserName(String username);

    User findByUserId(Integer id);

    boolean alreadyExist(String username);

    void remove(Integer userId);

    void updateImage(Integer id, String url);

    void updateContent(Integer id, User user);

    List<User> getUsersWithoutAdmin();

    void banUser(Integer id);

}
