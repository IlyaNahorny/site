package bsuir.service;

import bsuir.model.Rating;

/**
 * Created by Ilya on 08.03.2016.
 */
public interface RatingService {
    void addRating(Rating rating);
    int setOrUpdateRating(Rating rating);
    int getRatingMaterial(Integer id);
    void updateValue(Integer id, Rating rating);
}
