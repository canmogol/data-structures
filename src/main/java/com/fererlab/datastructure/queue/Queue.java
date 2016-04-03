package com.fererlab.datastructure.queue;

import com.fererlab.datastructure.collection.CCollection;
import com.fererlab.datastructure.collection.QCollection;
import com.fererlab.datastructure.iterator.Iterable;
import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.list.array.ArrayList;
import com.fererlab.datastructure.util.Maybe;

/**
 * There are no enqueue and dequeue methods, although "add(T value)" method
 * may be used as enqueue, there is no dequeue alternative.
 * <p/>
 * dequeue method in Queue implemented as follows which contradicts
 * to the command query separation principle which clearly
 * explains that those methods that changed the state should have
 * a return type of void.
 * <p/>
 * <code>
 * public Object dequeue();
 * </code>
 * <p/>
 * So if you want to implement a dequeue method with that signature,
 * you may implement as follows, be mindful of the synchronization.
 * <p/>
 * <code>
 * <pre>
 * public Object dequeue(){
 *   Object top = queue.peek(); // gets the top element
 *   queue.remove(); // removes the top element
 *   return top; // returns the top element
 * }
 * </pre>
 * </code>
 *
 * @param <T>
 */
public class Queue<T> implements QQueue<T>, CQueue<T>, Iterable<T> {

    /**
     * internal data structure to hold the values
     */
    private ArrayList<T> arrayList = new ArrayList<>();

    /**
     * Iterable
     */
    private Iterable<T> iterable = arrayList;

    /**
     * Query collection
     */
    private QCollection<T> queryCollection = arrayList;

    /**
     * Command collection
     */
    private CCollection<T> commandCollection = arrayList;

    /**
     * returns the iterator
     *
     * @return returns the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }

    /**
     * adds value
     *
     * @param value generic type T
     */
    @Override
    public void add(T value) {
        commandCollection.add(value);
    }

    /**
     * removes the head value
     */
    @Override
    public void remove() {
        commandCollection.remove(0);
    }

    /**
     * removes the value at index
     *
     * @param index index of the value
     */
    @Override
    public void remove(int index) {
        commandCollection.remove(index);
    }

    /**
     * removes the all value with this value
     *
     * @param value object value
     */
    @Override
    public void remove(T value) {
        commandCollection.remove(value);
    }

    /**
     * removes all values
     */
    @Override
    public void clear() {
        commandCollection.clear();
    }

    /**
     * returns the head of the queue
     *
     * @return head of the queue
     */
    @Override
    public Maybe<T> peek() {
        return queryCollection.get(0);
    }

    /**
     * returns the value at the index
     *
     * @param index int value position
     * @return returns the value at the index
     */
    @Override
    public Maybe<T> get(int index) {
        return queryCollection.get(index);
    }

    /**
     * returns true if the value exists
     *
     * @param value value to search
     * @return true if the value exists
     */
    @Override
    public boolean contains(T value) {
        return queryCollection.contains(value);
    }

    /**
     * size of the queue
     *
     * @return size of the queue
     */
    @Override
    public int getSize() {
        return queryCollection.getSize();
    }

}
