package me.ilcb.algorithm;

import java.util.Comparator;

/**
 * 排序器接口(策略模式: 将算法封装到具有共同接口的独立的类中使得它们可以相互替换)
 */
public interface Sorter {
    /**
     * 排序
     *
     * @param array 待排序的数组
     */
    <T extends Comparable<T>> void sort(T[] array);

    /**
     * 排序
     *
     * @param array 待排序的数组
     * @param comp  比较两个对象的比较器
     */
    <T> void sort(T[] array, Comparator<T> comp);

    /**
     * 排序
     *
     * @param array 待排序的数组
     * @param start 开始索引
     * @param end   开始索引
     */
    <T extends Comparable<T>> void sort(T[] array, int start, int end);

    /**
     * 基数排序
     *
     * @param array 待排序的数组
     * @param radix 基数
     */
    <T extends Comparable<T>> void sort(T[] array, int radix);
}

