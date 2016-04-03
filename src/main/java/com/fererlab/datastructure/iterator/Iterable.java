package com.fererlab.datastructure.iterator;

import java.util.function.Consumer;

/**
 * iteration interface for collections
 */
public interface Iterable<T> {

    /**
     * returns iterator for collection
     *
     * @return Iterator
     */
    Iterator<T> iterator();

    /**
     * functional interface for foreach
     *
     * @param action Consumer action
     */
    default void forEach(Consumer<? super T> action) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

}
