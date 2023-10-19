package Seminar3.GenericCollection;
/*
Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */

public class GenericArray<T> {
    private Object[] arr;
    private int endPosition;
    private GenericIterator<T> iterator;

    public GenericArray() {
        arr = new Object[3];
        iterator = new GenericIterator<>((T[]) arr);
        endPosition = 0;
    }

    public GenericArray(T t) {
        this();
        arr[endPosition++] = t;
    }

    public void add(T t) {
        if (endPosition < arr.length) {
            arr[endPosition++] = t;
        } else {
            extend(t);
        }
    }

    public void delete(T t) {
        Integer pos = findIndex(t);
        if (pos != null) {
            for (int i = pos + 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
                if (arr[i] == null) {
                    break;
                }
            }
            endPosition--;
        }
    }

    private Integer findIndex(T t) {
        for (int i = 0; i < arr.length; i++) {
            if (t.equals(arr[i])) {
                return i;
            }
        }
        return null;
    }

    private void extend(T t) {
        Object[] extendedArr = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            extendedArr[i] = arr[i];
        }
        extendedArr[endPosition++] = t;
        arr = extendedArr;
        iterator = new GenericIterator<>((T[]) arr);
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < endPosition - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[endPosition - 1] + "]");
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public T next() {
        return iterator.next();
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(1);
        array.add(2);
        array.add(3);
        array.delete(2);
        array.add(4);
        array.delete(2);
        System.out.println(array.next());
        System.out.println(array.next());
        System.out.println(array.next());
        System.out.println(array.hasNext());
        System.out.println(array.next());

        array.printArray();
    }
}
