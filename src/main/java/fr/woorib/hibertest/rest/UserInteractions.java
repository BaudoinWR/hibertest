package fr.woorib.hibertest.rest;

import fr.woorib.hibertest.dao.UserDao;
import fr.woorib.hibertest.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by baudoin on 18/01/17.
 */
@RestController
public class UserInteractions {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/listUsers")
    public List<UserEntity> listUsers() {
        return userDao.getAllUsers();
    }


    @GetMapping(path = "/init")
    public void init() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname("toto");
        userEntity.setName("namo");
        userDao.saveUser(userEntity);
    }

    @GetMapping(path ="/drop")
    public void deleteAllUsers() {
        userDao.dropAllUsers();
    }

    @PostMapping(path ="/createUser")
    public RedirectView createUser(UserEntity user) {
        userDao.saveUser(user);
        return new RedirectView("/listUsers");
    }
}
