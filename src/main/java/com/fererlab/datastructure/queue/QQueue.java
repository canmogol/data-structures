package com.fererlab.datastructure.queue;

import com.fererlab.datastructure.collection.QCollection;
import com.fererlab.datastructure.util.Maybe;

/**
 * Query interface of Queue
 *
 * @param <T>
 */
public interface QQueue<T> extends QCollection<T> {

    /**
     * Retrieves, but does not remove, the head of this queue
     *
     * @return head value
     */
    Maybe<T> peek();

}
