package com.fererlab.datastructure.stack;

import com.fererlab.datastructure.collection.QCollection;
import com.fererlab.datastructure.util.Maybe;

public interface QStack<T> extends QCollection<T> {

    Maybe<T> peek();

    int getSize();

    boolean contains(T value);

    boolean isEmpty();

}
