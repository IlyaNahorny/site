package bsuir.dao;

import bsuir.model.Material;

import java.util.List;

/**
 * Created by Ilya on 22.02.2016.
 */
public interface MaterialDao {
    void addMaterial(Material material);
    List<Material> getAllMaterials(String username);
    Material getMaterialByMaterialName(String materialName);
    Material getMaterialById(Integer id);
    void updateMaterialRating(Integer id, int value);
    void updateMaterialComment(Integer id, int value);
}
