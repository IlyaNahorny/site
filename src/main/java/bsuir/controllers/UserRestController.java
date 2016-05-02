package bsuir.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bsuir.model.Comment;
import bsuir.model.Material;
import bsuir.model.Rating;
import bsuir.model.User;
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
}
