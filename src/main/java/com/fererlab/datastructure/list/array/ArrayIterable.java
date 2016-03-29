package com.fererlab.datastructure.list.array;

import com.fererlab.datastructure.iterator.Iterable;
import com.fererlab.datastructure.iterator.Iterator;

/**
 * Iterable for array list
 *
 * @param <T>
 */
public interface ArrayIterable<T> extends Iterable<T> {

    /**
     * returns an iterator that iterates through elements in reverse order
     *
     * @return Iterator
     */
    Iterator<T> reverseIterator();

}
