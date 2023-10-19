package Seminar3.GenericCollection;
/*
Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа,
содержащим любые типы данных. Итераторы обычно имеют толькодва метода – проверка на наличие следующего элемента и
переход к следующему элементу. Но также, особенно в других языках программирования, возможно встретить итераторы,
реализующие дополнительную логику.
 */

import java.util.Iterator;

public class GenericIterator<T> implements Iterator<T>, Iterable<T> {
    private final T[] arr;
    private int position;

    public GenericIterator(T[] arr) {
        this.arr = arr;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return (position < arr.length && arr[position] != null);
    }

    @Override
    public T next() {
        if (hasNext()) {
            return arr[position++];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericIterator<>(arr);
    }
}
