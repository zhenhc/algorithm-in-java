package com.thealgorithms.sorts;

public class SelectionSort implements SortAlgorithm {

    /**
     * Generic selection sort algorithm in increasing order.
     *
     * @param arr the array to be sorted.
     * @param <T> the class of array.
     * @return sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    /**
     * 1.从数组中选择最小元素，将它与数组的第一个元素交换位置。
     * 2.再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
     * 3.不断进行这样的操作，直到将整个数组排序。
     * @param arr
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T[] sort1(T[] arr){
        int n=arr.length;
        for (int i =0 ; i< n - 1; i++){
            //假定最小元素是i
            int minIndex = i;
            for (int j = i+1; j< n; j++){
                if (SortUtils.greater(arr[minIndex],arr[j])){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                SortUtils.swap(arr,i,minIndex);
            }
        }
        return arr;
    }



    /**
     * Driver Code
     */
    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        SelectionSort selectionSort = new SelectionSort();
        Integer[] sorted = selectionSort.sort1(arr);
        for (int i = 0; i < sorted.length - 1; ++i) {
            assert sorted[i] <= sorted[i + 1];
        }
        SortUtils.print(sorted);
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort1(strings);
        SortUtils.print(sortedStrings);
        for (int i = 0; i < sortedStrings.length - 1; ++i) {
            assert strings[i].compareTo(strings[i + 1]) <= 0;
        }
    }
}
