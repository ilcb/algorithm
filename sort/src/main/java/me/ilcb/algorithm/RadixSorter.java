package me.ilcb.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 基数排序
 **/
public class RadixSorter implements Sorter {

    /**
     * @param array 待排序数组
     * @param radix 进制基数
     */
    public <T extends Comparable<T>> void sort(T[] array, int radix) {
        int length = array.length;

        // 获取数组中最大的数字用于计算最大位数
        T max = getMax(array);

        int bits = 0; //数组中最大数的位数
        int maxValue = Integer.valueOf(max.toString());
        //获取最大位数
        while (maxValue > 0) {
            maxValue /= 10;
            bits++;
        }

        Object[] buckets = new Object[length];
        int[] count = new int[radix]; // 存放各个桶的数据统计个数

        int rate = 1;
        // 按照从低位到高位的顺序执行排序过程
        for (int b = 0; b < bits; b++) {

            //重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);

            //计算每个待排序数据的关键字
            for (int i = 0; i < length; i++) {
                int key = Integer.valueOf(array[i].toString());

                int bucketIdx = (key / rate) % radix;
                ++count[bucketIdx];
            }

            // count[i]表示第i个桶的右边界索引
            for (int i = 1; i < radix; ++i) {
                count[i] = count[i] + count[i - 1];
            }

            // 将数据依次装入桶中, 开始从左向右，现在从右向左扫描，保证排序稳定性
            for (int i = length - 1; i >= 0; --i) {
                // 求出待排序元素第b位的数字，如34第2位是3
                int key = Integer.valueOf(array[i].toString());
                int bucketIdx = (key / rate) % radix;

                buckets[count[bucketIdx] - 1] = array[i]; //插入到count[key] - 1位，因为数组下标从0开始
                --count[bucketIdx];
            }
            rate *= radix; //前进一位
            System.out.print("\n 第" + (b + 1) + "次：");

            for (int i = 0; i < length; ++i) {
                array[i] = (T) buckets[i];
            }
            print(array);
        }
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


    //输出数组
    public <T extends Comparable<T>> void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + "\t");
        }
    }

    public <T extends Comparable<T>> void sort(T[] array) {

    }

    public <T> void sort(T[] array, Comparator<T> comp) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }
}
