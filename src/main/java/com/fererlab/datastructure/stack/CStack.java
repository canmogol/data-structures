package com.fererlab.datastructure.stack;

public interface CStack<T> {

    void push(T value);

    void remove();

    void remove(int index);

    void remove(T value);

    void clear();

}
