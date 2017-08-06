package me.ilcb.algorithm;

import com.sun.scenario.effect.Merge;

import java.util.Comparator;

public class SortContext<T extends Comparable<T>> {
    private Sorter sorter;
    private T[] array;
    private Comparator<T> comparator;
    private int radix;

    public SortContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    public void sort() {
        if (sorter instanceof BubbleSorter) { //冒泡排序
            sorter.sort(array);
        } else if (sorter instanceof InsertSorter) { //插入排序
            sorter.sort(array);
        } else if (sorter instanceof ShellSorter) { //希尔排序
            sorter.sort(array);
        } else if (sorter instanceof MergeSorter) { //归并排序
            sorter.sort(array, 0, array.length - 1);
        } else if (sorter instanceof QuickSorter) { //快速排序
            sorter.sort(array, 0, array.length - 1);
        } else if (sorter instanceof SelectSorter) { //选择排序
            sorter.sort(array);
        } else if (sorter instanceof HeapSorter) { //堆排序
            sorter.sort(array);
        } else if (sorter instanceof RadixSorter) { //基数排序
            sorter.sort(array, radix);
        } else if (sorter instanceof CountSorter) { //计数排序
            sorter.sort(array);
        } else if (sorter instanceof BucketSorter) { //桶排序
            sorter.sort(array);
        }
    }
}
