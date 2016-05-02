package bsuir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bsuir.dao.RatingDao;
import bsuir.model.Material;
import bsuir.model.Rating;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.Set;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao ratingDao;
    @Autowired
    MaterialService materialService;

    public void addRating(Rating rating) {
        ratingDao.addRating(rating);
    }

    public int setOrUpdateRating(Rating rating) {
        Integer id = rating.getMaterial().getId_material();
        Material material = materialService.getMaterialById(id);
        Set<Rating> ratings =  material.getRatings();
        Iterator iterator = ratings.iterator();
        boolean checkExist = false;
        while (iterator.hasNext()){

            Rating ratingOld = (Rating)iterator.next();
            if(rating.getUserName().equals(ratingOld.getUserName())){
                checkExist = true;
                if(ratingOld.getValue() != rating.getValue()){
                    updateValue(ratingOld.getId(), rating);
                }

            }
        }
        if(!checkExist){
            rating.setMaterial(material);
            addRating(rating);
        }
        return getRatingMaterial(id);
    }

    public int getRatingMaterial(Integer id) {
        Material material = materialService.getMaterialById(id);
        int value = 0;
        Set<Rating> ratings = material.getRatings();
        Iterator iterator = ratings.iterator();
        while (iterator.hasNext()){
            Rating rating1 = (Rating) iterator.next();
            value += rating1.getValue();
        }
        materialService.updateMaterialRating(id,value);
        return value;
    }

    public void updateValue(Integer id, Rating rating) {
        ratingDao.updateValue(id,rating);
    }
}
