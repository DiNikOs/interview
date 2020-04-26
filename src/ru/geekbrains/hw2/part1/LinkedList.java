/**
 * @author Ostrovskiy Dmitriy
 * @created 26.04.2020
 * LinkedList
 * @version v1.0
 */

package ru.geekbrains.hw2.part1;

public interface LinkedList<E> {

    boolean add(E value);

    void addFirst(E value);

    E get(int value);

    E getFirst();

    boolean remove(E value);

    E removeFirst();

    boolean contains(E value);

    boolean isEmpty();

    int size();

    static class Entry<E> {
        E value;
        Entry<E> next;
        Entry<E> prev;

        Entry(E value) {
            this.value = value;
        }

        Entry(Entry<E> prev, E value, Entry<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
