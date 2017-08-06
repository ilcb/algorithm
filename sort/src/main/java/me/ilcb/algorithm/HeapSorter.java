package me.ilcb.algorithm;

import java.util.Comparator;

public class HeapSorter implements Sorter {
    public <T extends Comparable<T>> void buildHeap(T[] array, int length) {
        for (int i = length / 2; i >= 0; i--) {//从最后一个非叶子节点，才能构成adjustHeap操作的目标二叉树
            adjustHeap(array, i, length);
        }
    }

    //这里将i定义为完全二叉树的根
    //将完全二叉树调整为大顶堆,前提是二叉树的根的子树已经为大顶堆。
    public <T extends Comparable<T>> void adjustHeap(T[] array, int curIdx, int size) {
        int lChild = 2 * curIdx + 1; //左孩子
        int rChild = 2 * curIdx + 2; //右孩子

        int k = curIdx;   //临时变量
        if (curIdx < size / 2) { //如果i是叶子节点就结束
            if (lChild < size && array[k].compareTo(array[lChild]) < 0) {
                k = lChild;
            }
            if (rChild < size && array[k].compareTo(array[rChild]) < 0) {
                k = rChild;
            }

            if (k != curIdx) {
                T temp = array[k];
                array[k] = array[curIdx];
                array[curIdx] = temp;
                adjustHeap(array, k, size);
            }
        }
    }

    //将数组分为两部分，一部分为有序区，在数组末尾，另一部分为无序区。堆属于无序区
    public <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        buildHeap(array, length);
        for (int i = length - 1; i > 0; i--) {//i为无序区的长度，经过如下两步，长度递减
            //堆顶即下标为0的元素
            T temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i);   //2.将无顺区调整为大顶堆，即选择出最大的元素。
        }
    }

    public <T> void sort(T[] array, Comparator<T> comp) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int start, int end) {

    }

    public <T extends Comparable<T>> void sort(T[] array, int radix) {

    }
}
