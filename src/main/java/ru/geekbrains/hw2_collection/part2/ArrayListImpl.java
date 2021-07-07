/**
 * @author Ostrovskiy Dmitriy
 * @created 27.04.2020
 * ArrayListImpl
 * @version v1.0
 */

package ru.geekbrains.hw2_collection.part2;

import java.util.Arrays;

public class ArrayListImpl<E> implements ArrayList<E> {

    private static final int CAPACITY = 10;

    protected E[] data;
    protected int size;


    @SuppressWarnings("unchecked")
    public ArrayListImpl(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
    }

    public ArrayListImpl() {
        this(CAPACITY);
    }

    @Override
    public void add(E value) {
        doGrow();
        data[size++] = value;
    }

    protected void doGrow() {
        if (size == data.length) {
            data = grow(0);
        }
    }

    private E[] grow(int i) {
        return Arrays.copyOf(data, i!=0? i :data.length * 2);
    }

    private void verifyIndex(int ind) {
        if (0 > ind || ind >= size) {
            throw new IndexOutOfBoundsException("index:" + ind + ", Size:" + size);
        }
    }

    @Override
    public E get(int index) {
        verifyIndex(index);
        return  data[index];
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    public void ensureCapacity(int capacity) {
        if (size < capacity) {
            grow(capacity);
        }
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
