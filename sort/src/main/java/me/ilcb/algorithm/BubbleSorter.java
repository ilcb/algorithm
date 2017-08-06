package me.ilcb.algorithm;

import java.util.Comparator;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0, length = array.length; i < length - 1; ++i) { // 排序需进行length - 1轮
            boolean swapped = false; //设定一个标记，若为false，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成

            for (int j = 0; j < length - i - 1; ++j) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {
        for (int i = 0, length = array.length; i < length; ++i) {
            boolean swapped = false; //设定一个标记，若为false，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成
            for (int j = 0; j < length - i - 1; ++j) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }
}
