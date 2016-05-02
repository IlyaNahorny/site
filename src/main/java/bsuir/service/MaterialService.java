package bsuir.service;

import bsuir.model.Material;

/**
 * Created by Ilya on 22.02.2016.
 */
public interface MaterialService {
    public void addMaterial(Material material);
    Material getMaterialByMaterialName(String materialName);
    Material getMaterialById(Integer id);
    void updateMaterialRating(Integer id, int value);
    void updateMaterialComment(Integer id, int value);

}
