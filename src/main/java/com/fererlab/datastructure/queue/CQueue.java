package com.fererlab.datastructure.queue;

import com.fererlab.datastructure.collection.CCollection;

/**
 * Command interface of Queue
 *
 * @param <T>
 */
public interface CQueue<T> extends CCollection<T> {

    /**
     * adds value to queue
     *
     * @param value add value to queue
     */
    void add(T value);

    /**
     * removes the head of the queue
     */
    void remove();

}
