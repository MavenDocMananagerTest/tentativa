package br.edu.utfpr.md.webapp.dao;

import java.util.List;

public abstract class GenericDAO<T, PK> {
    public abstract void insert(T obj);
    public abstract void update(T obj);
    public abstract void delete(T obj);
    public abstract List<T> getAll();
    public abstract T getById(PK id);
}
