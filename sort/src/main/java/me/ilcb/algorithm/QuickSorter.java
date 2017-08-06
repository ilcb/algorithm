package me.ilcb.algorithm;

import java.util.Comparator;

public class QuickSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (start < end) {
            int left = start; // 左端索引
            int right = end; // 右端索引

            T base = array[start]; // 选定的基准值

            T temp; // 记录临时中间值
            while (left < right) {
                while (array[left].compareTo(base) < 0 && (left < end)) {
                    // 左索引往后移，直到找到不小于base的数才停下来
                    ++left;
                }
                while (array[right].compareTo(base) > 0 && (right > start)) {
                    // 右索引往前移，直到找到不大于base的数才停下来
                    --right;
                }
                if (left <= right) {
                    temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;

                    ++left;
                    --right;
                }
            }

            if (right > start) {
                //递归，排左索引前面的数
                sort(array, start, right);
            }

            if (left < end) {
                //递归，排右索引后面的数
                sort(array, left, end);
            }
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }


    public <T extends Comparable<T>> void sort(T[] array) {

    }

    public <T> void sort(T[] array, Comparator<T> comp) {

    }
}
