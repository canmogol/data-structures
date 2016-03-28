package com.fererlab.datastructure.list.array;

import com.fererlab.datastructure.iterator.Iterable;
import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.util.Maybe;

/**
 * final class ArrayList, implements Query and Command interfaces of ArrayList
 *
 * @param <T> generic type of the value
 */
public final class ArrayList<T> implements QArrayList<T>, CArrayList<T>, Iterable<T> {

    private int step;
    private Object[] objects;
    private int size = 0;


    /**
     * internal iterator class
     */
    class InternalIterator extends Iterator<T> {

        /**
         * index will start from size
         */
        private int index = getSize();

        @Override
        protected int getSize() {
            return ArrayList.this.getSize();
        }

        @Override
        protected Maybe<T> get(int currentIndex) {
            return ArrayList.this.get(currentIndex);
        }

        @Override
        protected void remove(int currentIndex) {
            ArrayList.this.remove(currentIndex);
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        /**
         * returns the last value in the list, this prevents array copy
         *
         * @return value
         */
        @Override
        public T next() {
            index--;
            return get(index).get();
        }

        @Override
        public void remove() {
            remove(index);
        }
    }

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initialCapacity) {
        this.step = initialCapacity;
        this.objects = new Object[step];
    }

    @Override
    public void add(T value) {
        if (size >= objects.length - 1) {
            expand();
        }
        objects[size] = value;
        size++;
    }

    private void expand() {
        Object[] temp = objects;
        objects = new Object[objects.length + step];
        System.arraycopy(temp, 0, objects, 0, temp.length);
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index <= size - 1) {
            // the object to be removed
            Object removed = objects[index];
            // set null to that index, object will be GC'd
            objects[index] = null;
            /**
             * size     index       object array length
             * 6                    10
             * 1-2-3-4-5-6-*-*-*-*
             *
             * 6        3           10
             * 1-2-3-[4]-5-6-*-*-*-*
             * 1-2-3-X-5-6-*-*-*-*-*
             * 1-2-3-5-6-*-*-*-*-*-*
             *
             */
            // number of elements to move
            int numberOfElementsToMove = size - index - 1;
            // this might be the last element, if so do nothing
            if (numberOfElementsToMove > 0) {
                Object[] temp = objects;
                objects = new Object[index + numberOfElementsToMove];
                System.arraycopy(temp, 0, objects, 0, index);
                System.arraycopy(temp, index + 1, objects, index, numberOfElementsToMove);
            }
            // decrease size
            size--;
        }
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(value)) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        objects = new Object[step];
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new InternalIterator();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Maybe<T> get(int index) {
        Maybe<T> maybe = Maybe.empty();
        if (index >= 0 && index <= size - 1) {
            T value = (T) objects[index];
            maybe = Maybe.create(value);
        }
        return maybe;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        for (Object object : objects) {
            if (object.equals(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public int getSize() {
        return size;
    }

}
