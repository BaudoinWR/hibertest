package fr.woorib.hibertest.dao;

import fr.woorib.hibertest.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baudoin on 18/01/17.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(UserEntity.class).list();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void dropAllUsers() {
        List<UserEntity> allUsers = getAllUsers();
        final Session currentSession = sessionFactory.getCurrentSession();
        allUsers.forEach(userEntity -> currentSession.delete(userEntity));
    }
}
