package bsuir.dao;

import bsuir.model.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ilya on 13.02.2016.
 */
@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(UserRole userRole) {
        entityManager.persist(userRole);
    }
}
