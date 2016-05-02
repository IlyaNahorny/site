package bsuir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bsuir.dao.MaterialDao;
import bsuir.model.Material;

import javax.transaction.Transactional;

/**
 * Created by Ilya on 22.02.2016.
 */
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao materialDao;

    public Material getMaterialByMaterialName(String materialName) {
        Material material = materialDao.getMaterialByMaterialName(materialName);
        return material;
    }

    public Material getMaterialById(Integer id) {
        return materialDao.getMaterialById(id);
    }

    public void addMaterial(Material material) {
        materialDao.addMaterial(material);

    }

    public void updateMaterialRating(Integer id, int value) {
        materialDao.updateMaterialRating(id,value);
    }

    public void updateMaterialComment(Integer id, int value) {
        materialDao.updateMaterialComment(id,value);
    }
}
