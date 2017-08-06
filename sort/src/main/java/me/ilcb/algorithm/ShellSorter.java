package me.ilcb.algorithm;

import java.util.Comparator;

public class ShellSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        int gap = length / 2; //分组数
        while (gap > 0) {
            //把距离为gap的元素编为一个组，扫描所有组
            for (int i = gap; i < length; ++i) {
                int j = i - gap;

                //对距离为gap的元素组进行排序
                while (j >= 0 && array[j + gap].compareTo(array[j]) < 0) {
                    T temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;

                    j -= gap;
                }
            }
            gap /= 2;
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {
        int length = array.length;
        int gap = length / 2; //分组数
        while (gap > 0) {
            //把距离为gap的元素编为一个组，扫描所有组
            for (int i = gap; i < length; ++i) {
                int j = i - gap;

                //对距离为gap的元素组进行排序
                while (j >= 0 && comp.compare(array[j + gap], array[j]) < 0) {
                    T temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;

                    j -= gap;
                }
            }
            gap /= 2;
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }
}
