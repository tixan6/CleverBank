package org.example.Model.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    Optional<List<K>> findAll();
    K findById(T id);
    boolean delete(T id);
    K save(K entity);
    boolean update(K entity);
}
