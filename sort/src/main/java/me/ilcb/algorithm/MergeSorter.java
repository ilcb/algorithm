package me.ilcb.algorithm;

import java.util.Comparator;

public class MergeSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] array) {

    }

    public <T> void sort(T[] array, Comparator<T> comp) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }

    //递归实现二路归并排序（分治法）
    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        //二路归并排序，分为二路
        int mid = (start + end) / 2;
        if (start < end) {
            // 递归过程
            sort(array, start, mid);
            sort(array, mid + 1, end);

            //合并
            merge(array, start, mid, end);
        }
    }


    // 归并排序
    public <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
        int l = low; // 左数组第一个元素的索引
        int h = mid + 1; // 右数组第1个元素
        int t = 0; // 临时数组索引

        Object[] temp = new Object[array.length]; // 存放临时序列
        while (l <= mid && h <= high) { // 扫描第一段和第二段序列，直到有一个扫描结束
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[l].compareTo(array[h]) <= 0) {
                temp[t++] = array[l++];
            } else {
                temp[t++] = array[h++];
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (l <= mid) {
            temp[t++] = array[l++];
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (h <= high) {
            temp[t++] = array[h++];
        }

        // 将合并后的序列复制到原始序列中
        for (int k = 0, i = low; i <= high; ++i, ++k) {
            array[i] = (T) temp[k];
        }
    }

    // 非递归实现归并
    public <T extends Comparable<T>> void mergeSort(T[] array, int length) {
        int size = 1; //size标记当前各个归并序列的high-low，从1，2，4，8，……，2*size
        int low;
        int mid;
        int high;

        while (size <= length - 1) {
            //从第一个元素开始扫描，low代表第一个分割的序列的第一个元素
            low = 0;
            while (low + size <= length - 1) {
                //mid代表第一个分割的序列的最后一个元素
                mid = low + size - 1;

                //high 代表第二个分割的序列的最后一个元素
                high = mid + size;

                // 如果第二个序列个数不足size个
                if (high > length - 1) {
                    //调整 high 为最后一个元素的下标即可
                    high = length - 1;
                }

                // 调用归并方法，进行分割的序列分段排序
                merge(array, low, mid, high);

                //下一次归并时第一序列的第一个元素位置
                low = high + 1;
            }
            size *= 2;
        }
    }


}
