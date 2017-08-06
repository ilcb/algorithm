package me.ilcb.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BucketSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;

        T maxValue = getMax(array);
        int max = Integer.valueOf(maxValue.toString());

        List<List<T>> buckets = new ArrayList<>();
        for (int i = 0; i < max + 1; ++i) {
            List<T> list = new ArrayList<>();
            buckets.add(list);
        }

        //将每个元素放入桶
        for (int i = 0; i < array.length; ++i) {
            T element = array[i];
            int index = Integer.valueOf(element.toString());

            buckets.get(index).add(element);
        }

        Object[] tempArray = new Object[length];
        for (int i = 0, j = 0; i < buckets.size(); ++i) {
            List<T> list = buckets.get(i);
            Collections.sort(list);
            for (int k = 0; k < list.size(); ++k) {
                T element = list.get(k);
                if (element != null) {
                    tempArray[j++] = element;
                }
            }
        }

        for (int i = 0; i < length; ++i) {
            array[i] = (T) tempArray[i];
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }

    public <T extends Comparable<T>> T getMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

}
