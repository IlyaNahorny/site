package bsuir.service;

import bsuir.dao.UserRoleDao;
import bsuir.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    public void add(UserRole userRole) {
        userRoleDao.add(userRole);
    }
}
