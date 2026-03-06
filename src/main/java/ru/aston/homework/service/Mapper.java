package ru.aston.homework.service;

public interface Mapper<T,R> {

    T convertToEntity(R r);

    R convertToDTO(T t);
}
