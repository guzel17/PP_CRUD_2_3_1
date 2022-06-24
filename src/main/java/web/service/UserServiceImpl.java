package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }
}
