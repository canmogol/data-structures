package com.fererlab.datastructure.stack;

import com.fererlab.datastructure.util.Maybe;

public interface QStack<T> {

    Maybe<T> peek();

    int getSize();

    boolean contains(T value);

    boolean isEmpty();

}
