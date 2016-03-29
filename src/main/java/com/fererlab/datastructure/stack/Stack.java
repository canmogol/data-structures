package com.fererlab.datastructure.stack;

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
 * you may implement as follows, be mindful of the synchronization though.
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
public class Stack<T> implements QStack<T>, CStack<T>, Iterable<T> {

    /**
     * internal data structure of stack
     */
    private LinkedList<T> list = new LinkedList<>();

    /**
     * adds the value to the top
     *
     * @param value of type T
     */
    @Override
    public void push(T value) {
        list.add(value);
    }

    /**
     * removes the top value
     */
    @Override
    public void remove() {
        remove(0);
    }

    /**
     * removes the value at index, will throw exception if the index is not out within the stack
     *
     * @param index int value index
     */
    @Override
    public void remove(int index) {
        list.remove(index);
    }

    /**
     * removes the value
     *
     * @param value to be removed
     */
    @Override
    public void remove(T value) {
        list.remove(value);
    }

    /**
     * removes all elements from stack
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * returns the top element of the stack
     *
     * @return Maybe of T
     */
    @Override
    public Maybe<T> peek() {
        return list.get(0);
    }

    /**
     * returns the size of the stack
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean contains(T value) {
        return list.contains(value);
    }

    /**
     * returns if the stack is empty
     *
     * @return returns if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    /**
     * returns the iterator
     *
     * @return returns the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
