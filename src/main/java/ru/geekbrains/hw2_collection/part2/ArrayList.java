/**
 * @author Ostrovskiy Dmitriy
 * @created 27.04.2020
 * ArrayList
 * @version v1.0
 */

package ru.geekbrains.hw2_collection.part2;

public interface ArrayList<E> {

    void add(E value);

    E get(int index);

    boolean remove(E value);

    boolean contains(E value);

//    default boolean contains(E value) {
//        return indexOf(value) != -1;
//    }

    void ensureCapacity(int capacity);

    int indexOf(E value);

    int size();

    boolean isEmpty();
}
