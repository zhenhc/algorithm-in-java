## 工具类-方便比较大小，交换元素，打印数组
```java
final class SortUtils {
    
    static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }
    
    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    
    static <T extends Comparable<T>> boolean greater(T v, T w) {
        return v.compareTo(w) > 0;
    }
    
    static <T extends Comparable<T>> boolean greaterOrEqual(T v, T w) {
        return v.compareTo(w) >= 0;
    }
    
    static void print(List<?> toPrint) {
        toPrint.stream().map(Object::toString).map(str -> str + " ").forEach(System.out::print);

        System.out.println();
    }
    
    static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }
    
    static <T extends Comparable<T>> void flip(T[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }
}
```
## 冒泡排序
```java
class BubbleSort implements SortAlgorithm {
    /**
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
     * @param array
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T[] sort1(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                //比较相邻两个元素，如果左边比右边大，那么就交换这两个元素
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            //在一轮循环中，如果变量swapped = false,说明没有发生交换，数组已经是有序的，直接break跳出循环。
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
```