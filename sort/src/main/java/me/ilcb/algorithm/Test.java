package me.ilcb.algorithm;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        Random random = new Random(100);
        System.out.print("  初始: ");
        for (int i = 0; i < 10; ++i) {
            Integer num = random.nextInt(100) + 1;
            array[i] = num;
            System.out.print(num + "\t");
        }

        Sorter sorter = new RadixSorter();
        SortContext<Integer> context = new SortContext<Integer>(sorter);
        context.setArray(array);
        context.setRadix(10);


      /*  Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        context.setComparator(comparator);*/

        context.sort();

        System.out.print("\n排序后: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
