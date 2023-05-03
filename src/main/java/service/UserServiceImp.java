package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class UserServiceImp implements UserService {

    private final EntityManager entityManager;

    @Autowired
    public UserServiceImp(EntityManager theEntityManager)
    {

         entityManager = theEntityManager;
    }

    @Autowired
    private UserDao userDao;


@Override
    public User getUser(User userDetails) {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "FROM User WHERE password = :password AND username = :username", User.class);
        try {
            User user = typedQuery.setParameter("password", userDetails.getPassword()).setParameter("username", userDetails.getUsername()).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User insertIntoDatabase(User user) {
        return userDao.save(user);
    }
    
}
