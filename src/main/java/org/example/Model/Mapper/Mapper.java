package org.example.Model.Mapper;

public interface Mapper<F, T> {
    public T fromTo(F object);

}
