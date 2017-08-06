package me.ilcb.algorithm;

import java.util.Comparator;

public class SelectSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length; ++i) { //循环n次
            T minest = array[i];
            int position = i;

            for (int j = i + 1; j < length; ++j) {//选出最小的值和位置
                if (array[j].compareTo(minest) < 0) {
                    minest = array[j];
                    position = j;
                }
            }

            array[position] = array[i];
            array[i] = minest;
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {
        int length = array.length;
        for (int i = 0; i < length; ++i) { //循环n次
            T minest = array[i];
            int position = i;

            for (int j = i + 1; j < length; ++j) {//选出最小的值和位置
                if (comp.compare(array[j], minest) < 0) {
                    minest = array[j];
                    position = j;
                }
            }

            array[position] = array[i];
            array[i] = minest;
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }
}
