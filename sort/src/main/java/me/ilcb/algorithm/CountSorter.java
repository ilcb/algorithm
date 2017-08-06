package me.ilcb.algorithm;

import java.util.Comparator;

public class CountSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;

        T maxValue = getMax(array);
        //数组里所有的数字都小于range
        int range = Integer.valueOf(maxValue.toString());
        int[] countArray = new int[range + 1];

        //统计每个数组元素array[i]在数组中出现的个数
        for (int i = 0; i < length; ++i) {
            int value = Integer.valueOf(array[i].toString());
            ++countArray[value];
        }

        //通过在countArray中记录计数和，countArray中存放的是小于等于i元素的数字个数
        for (int i = 1; i < countArray.length; ++i) {
            countArray[i] += countArray[i - 1];
        }

        Object[] tempArray = new Object[length];
        // 把待排序数组中的元素放在临时数组中对应的位置上
        for (int i = length - 1; i >= 0; --i) {
            int value = Integer.valueOf(array[i].toString());
            int position = countArray[value] - 1;

            tempArray[position] = value;
            --countArray[value];
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
        for (int i = 0; i < array.length; ++i) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
