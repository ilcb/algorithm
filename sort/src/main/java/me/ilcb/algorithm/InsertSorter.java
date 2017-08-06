package me.ilcb.algorithm;

import java.util.Comparator;

public class InsertSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        int preIndex;
        T current;

        for (int i = 1; i < length; ++i) {
            current = array[i]; // 待插入的数
            preIndex = i - 1; // 待插入的位置

            while (preIndex >= 0 && current.compareTo(array[preIndex]) < 0) {
                // 从后到前循环，将大于current的数向后移动一格
                array[preIndex + 1] = array[preIndex];
                --preIndex;
            }
            array[preIndex + 1] = current;
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {
        int length = array.length;
        int preIndex;
        T current;

        for (int i = 1; i < length; ++i) {
            current = array[i]; // 待插入的数
            preIndex = i - 1; // 待插入的位置

            while (preIndex >= 0 && comp.compare(current, array[preIndex]) < 0) {
                // 从后到前循环，将大于current的数向后移动一格
                array[preIndex + 1] = array[preIndex];
                --preIndex;
            }
            array[preIndex + 1] = current;
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }
}
