package com.fererlab.datastructure.stack;

import com.fererlab.datastructure.collection.QCollection;

public interface CStack<T> extends QCollection<T> {

    void push(T value);

    void remove();

    void remove(int index);

    void remove(T value);

    void clear();

}
