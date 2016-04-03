package com.fererlab.datastructure.stack;

import com.fererlab.datastructure.collection.CCollection;
import com.fererlab.datastructure.collection.QCollection;
import com.fererlab.datastructure.iterator.Iterable;
import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.list.linked.LinkedList;
import com.fererlab.datastructure.util.Maybe;

/**
 * Stack implementation with command query interfaces and
 * in favour of composition over inheritance,
 * {@code LinkedList} preferred as the internal data structure
 * <p/>
 * Notice that there is no {@code Stack#pop} method available
 * pop method in Stack implemented as follows which contradicts
 * to the command query separation principle which clearly
 * explains that those methods that changed the state should have
 * a return type of void.
 * <p/>
 * <code>
 * public Object pop();
 * </code>
 * <p/>
 * So if you want to implement a pop method with that signature,
 * you may implement as follows, be mindful of the synchronization.
 * <p/>
 * <code>
 * <pre>
 * public Object pop(){
 *   Object top = stack.peek(); // gets the top element
 *   stack.remove(); // removes the top element
 *   return top; // returns the top element
 * }
 * </pre>
 * </code>
 *
 * @param <T> parametrized type
 */
public final class Stack<T> implements QStack<T>, CStack<T>, Iterable<T> {

    /**
     * internal data structure of stack
     */
    private LinkedList<T> linkedList = new LinkedList<>();

    /**
     * Iterable
     */
    private Iterable<T> iterable = linkedList;

    /**
     * Query collection
     */
    private QCollection<T> queryCollection = linkedList;

    /**
     * Command collection
     */
    private CCollection<T> commandCollection = linkedList;

    /**
     * adds the value to the top
     *
     * @param value of type T
     */
    @Override
    public void push(T value) {
        commandCollection.add(value);
    }

    /**
     * removes the top value
     */
    @Override
    public void remove() {
        this.remove(0);
    }

    /**
     * removes the value at index, will throw exception if the index is not out within the stack
     *
     * @param index int value index
     */
    @Override
    public void remove(int index) {
        commandCollection.remove(index);
    }

    /**
     * removes the value
     *
     * @param value to be removed
     */
    @Override
    public void remove(T value) {
        commandCollection.remove(value);
    }

    /**
     * removes all elements from stack
     */
    @Override
    public void clear() {
        commandCollection.clear();
    }

    /**
     * returns the top element of the stack
     *
     * @return Maybe of T
     */
    @Override
    public Maybe<T> peek() {
        return queryCollection.get(0);
    }

    /**
     * returns the value at the index
     *
     * @param index int value position
     * @return a maybe of value
     */
    @Override
    public Maybe<T> get(int index) {
        return queryCollection.get(index);
    }

    /**
     * returns the size of the stack
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return queryCollection.getSize();
    }

    /**
     * returns the size
     *
     * @param value value to search
     * @return returns the size
     */
    @Override
    public boolean contains(T value) {
        return queryCollection.contains(value);
    }

    /**
     * returns if the stack is empty
     *
     * @return returns if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return queryCollection.getSize() == 0;
    }

    /**
     * returns the iterator
     *
     * @return returns the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }
}
