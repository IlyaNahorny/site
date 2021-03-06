package bsuir.service;

import bsuir.dao.UserDao;
import bsuir.dao.UserRoleDao;
import bsuir.model.User;
import bsuir.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    public User findByUserId(Integer id) {
        return userDao.findByUserId(id);
    }

    public void add(User user) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setUrl("https://vk.com/images/camera_200.png");
        user.setStyle("default");
        userDao.add(user);
        userRoleDao.add(userRole);
    }

    public void updateContent(Integer id, User user) {
        userDao.updateContent(id,user);
    }

    public void updateImage(Integer id, String url) {
        userDao.updateImage(id,url);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> getUsersWithoutAdmin(){
        String username = "";
        List<User> users = getAllUsers();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user = (User)iterator.next();
            Set<UserRole> userRoles =  user.getUserRoles();
            Iterator iteratorRole = userRoles.iterator();
            while (iteratorRole.hasNext()){
                UserRole userRole = (UserRole) iteratorRole.next();
                if(userRole.getRole().equals("ROLE_ADMIN")){
                    username = userRole.getUser().getUsername();
                }

            }
            if(!username.equals("")){
                iterator.remove();
                username = "";
            }

        }
        return users;
    }

    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    public boolean alreadyExist(String username) {
        return userDao.alreadyExist(username);
    }

    public void remove(Integer userId) {
        userDao.remove(userId);
    }

    public void banUser(Integer id) {
        userDao.banUser(id);
    }
}
