package ru.aston.homework.dao;

public interface DAO<T> {

    T findById(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
