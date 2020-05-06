/**
 * @author Ostrovskiy Dmitriy
 * @created 26.04.2020
 * LinkedListImpl
 * @version v1.0
 */

package ru.geekbrains.hw2_collection.part1;

public class LinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected Entry<E> lastElement;
    protected int size;
    protected int count = 0;

    // add in last List
    @Override
    public boolean add(E value) {
        Entry<E> last = lastElement;
        Entry<E> newEntry = new Entry<E>(last, value, null);
        lastElement = newEntry;
        if (last == null) {
            firstElement = newEntry;
        } else {
            last.next = newEntry;
        }
        size++;
        count++;
        return true;
    }

    // add in first List
    @Override
    public void addFirst(E value) {
        Entry<E> first = firstElement;
        Entry<E> entry = new Entry<E>(null, value, first);
        entry.next = firstElement;
        firstElement = entry;
        size++;
        count++;
    }

    @Override
    public E get(int ind) {
        if (ind < (size >> 1)) {
            Entry<E> current = firstElement;
            for (int i = 0; i < ind ; i++) {
                current = current.next;
                return current.value;
            }
        } else {
            Entry<E> current = lastElement;
            for (int i = size - 1; ind < i; i--) {
                current = current.prev;
                return current.value;
            }
        }
        throw new IndexOutOfBoundsException("index:" + ind + ", Size:" + size);
    }

    @Override
    public E getFirst() {
        return firstElement.value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removedValue = this.firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
