package ru.aston.homework.service;

import java.util.List;

public interface Service<T> {

    T findByID(Long id);

    void saveUser(T t);

    void deleteUser(T t);

    void updateUser(T t);

    List<T> findAll();
}
