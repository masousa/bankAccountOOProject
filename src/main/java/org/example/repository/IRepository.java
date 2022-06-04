package org.example.repository;

public interface IRepository<T> {

     void save(T object);

     T read (T object);
}
