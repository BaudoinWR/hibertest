package fr.woorib.hibertest.dao;

import fr.woorib.hibertest.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baudoin on 18/01/17.
 */
public interface UserDao {

    public List<UserEntity> getAllUsers();
    public void saveUser(UserEntity userEntity);

    @Transactional(readOnly = false)
    void dropAllUsers();
}
