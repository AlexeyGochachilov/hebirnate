package ru.aston.homework.service;

import ru.aston.homework.dao.DAO;
import ru.aston.homework.entity.User;

public class UserServiceIMPL implements Service<User> {

    private final DAO<User> userDAO;

    public UserServiceIMPL(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findUser(int id) {
        System.out.println("Try find user with id: " + id);
        return userDAO.findById(id);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("Tru save user: " + user.toString());
        userDAO.save(user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("Try delete user: " + user.toString());
        userDAO.delete(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Try update user: " + user.toString());
        userDAO.update(user);
    }
}
