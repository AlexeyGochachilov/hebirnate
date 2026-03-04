package ru.aston.homework.service;

public interface Service<T> {

    T findUser(int id);

    void saveUser(T t);

    void deleteUser(T t);

    void updateUser(T t);
}
