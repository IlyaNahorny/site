package bsuir.controllers;

import bsuir.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bsuir.service.*;

import java.util.List;

/**
 * Created by Ilya on 20.02.2016.
 */
@RestController
public class UserRestController {
    @Autowired
    UserService userService;
    @Autowired
    MaterialService materialService;
    @Autowired
    RatingService ratingService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;

    User getCurrentUser(){
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return userService.findByUserName(auth.getName());
        } catch (Exception ex)
        {
            return null;
        }
    }

    @RequestMapping(value="/update/image", method = RequestMethod.POST)
    public void updateImage(@RequestBody User user){
        userService.updateImage(getCurrentUser().getId(),user.getUrl());
        commentService.updateUrlPictures(getCurrentUser().getUsername(), user.getUrl());
    }

    @RequestMapping(value="/material/rating/set", method = RequestMethod.POST)
    public int setRating(@RequestBody Rating rating){
        return ratingService.setOrUpdateRating(rating);
    }

    @RequestMapping(value = "/material/get", method = RequestMethod.GET)
    public Material getRating(){
        return materialService.getMaterialById(Condition.getIdMaterial());
    }

    @RequestMapping(value = "/material/add", method = RequestMethod.POST)
    public void addMaterial(@RequestBody Material material){
        material.setUser(getCurrentUser());
        materialService.addMaterial(material);
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public Material addComment(@RequestBody Comment comment){
        comment.setUsername(getCurrentUser().getUsername());
        comment.setUrl(getCurrentUser().getUrl());
        commentService.add(comment);
        Integer id = comment.getMaterial().getId_material();
        materialService.updateMaterialComment(id,commentService.getAmountComments(id));
        return materialService.getMaterialById(id);
    }

    @RequestMapping(value = "/comments/get", method = RequestMethod.GET)
    public List<Comment> getComments(){
        return commentService.getCommentsByMaterialId(Condition.getIdMaterial());
    }

    @RequestMapping(value = "get/users" , method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping (value = "user/delete", method = RequestMethod.POST)
    public List<User> deleteUser(@RequestBody User user){
        userService.remove(user.getId());
        return userService.getUsersWithoutAdmin();
    }

    @RequestMapping (value = "user/ban", method = RequestMethod.POST)
    public List<User> banUser(@RequestBody User user){
        userService.banUser(user.getId());
        return userService.getUsersWithoutAdmin();
    }

    @RequestMapping(value = "users/withoutAdmin" , method = RequestMethod.GET)
    public List<User> getUsersWithoutAdmin(){
        return userService.getUsersWithoutAdmin();
    }

    @RequestMapping(value = "/like/set", method = RequestMethod.POST)
    public Material  setLike(@RequestBody Like like){
        List<Like> likes = likeService.getLikesByIdComment(like.getComment_id());
        Like likeExist = likeService.checkLike(likes, like.getUserName());
        if (likeExist != null){
            likeService.deleteLike(likeExist);
        }else {
            likeService.addLike(like);
        }
        likes = likeService.getLikesByIdComment(like.getComment_id());
        commentService.updateLike(like.getComment_id(), likeService.numberOfLikes(likes));
        return materialService.getMaterialById(commentService.getCommentById(like.getComment_id()).getMaterial().getId_material());
    }

}
