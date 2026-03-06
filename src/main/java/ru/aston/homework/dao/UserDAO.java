package ru.aston.homework.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.aston.homework.entity.UserEntity;
import ru.aston.homework.factory.HibernateSessionFactory;

import java.util.List;

public class UserDAO implements DAO<UserEntity> {

    @Override
    public UserEntity findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(UserEntity user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UserEntity user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) HibernateSessionFactory.
                getSessionFactory().openSession().createQuery("From UserEntity").list();
    }
}
