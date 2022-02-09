package com.thealgorithms.sorts;

import static com.thealgorithms.sorts.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */
class BubbleSort implements SortAlgorithm {

    /**
     * Implements generic bubble sort algorithm.
     *
     * @param array the array to be sorted.
     * @param <T> the type of elements in the array.
     * @return the sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    /**
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
     * @param array
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T[] sort1(T[] array){
        for (int i=1,size = array.length;i<size;++i){
            boolean swapped = false;
            for (int j=0;j<size-i;++j){
                //比较相邻两个元素，如果左边比右边大，那么就交换这两个元素
                if (greater(array[j],array[j+1])){
                    swap(array,j,j+1);
                    swapped = true;
                }
            }
            //在一轮循环中，如果变量swapped = false,说明没有发生交换，数组已经是有序的，直接break跳出循环。
            if (!swapped){
                break;
            }
        }
        return array;
    }

    /**
     * Driver Code
     */
    public static void main(String[] args) {

        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort1(integers);

        for (int i = 0; i < integers.length - 1; ++i) {
            assert integers[i] <= integers[i + 1];
        }
        print(integers);
        /* output: [1, 4, 6, 9, 12, 23, 54, 78, 231] */

        String[] strings = {"c", "a", "e", "b", "d"};
        bubbleSort.sort(strings);
        for (int i = 0; i < strings.length - 1; i++) {
            assert strings[i].compareTo(strings[i + 1]) <= 0;
        }
        print(bubbleSort.sort(strings));
        /* output: [a, b, c, d, e] */
    }
}
