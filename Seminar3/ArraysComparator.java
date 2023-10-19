package Seminar3;

public class ArraysComparator {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длина массивов не совпадает.");
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!(arr1[i].equals(arr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3};
        Integer[] arr2 = new Integer[]{1, 2, 3};

        String[] arr3 = new String[]{"a", "b", "e"};
        String[] arr4 = new String[]{"a", "b", "c"};

        System.out.println(ArraysComparator.compareArrays(arr1, arr2));
        System.out.println(ArraysComparator.compareArrays(arr3, arr4));
    }
}
