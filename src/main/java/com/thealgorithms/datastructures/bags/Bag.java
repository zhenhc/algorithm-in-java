package com.thealgorithms.datastructures.bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Collection which does not allow removing elements (only collect and iterate)
 *
 * @param <Element> - the generic type of an element in this bag
 */

/**
 * 包：一种只能塞值不能取值的结构。即这个类对外暴露的api永远只有add()，没有get()。
 * 他的特性在于遍历内部数据时，并不一定需要按照顺序。侧重点在于统计（如求数字的总和，平均值，方差等），而不在于搜索。
 * @param <Element>
 */
public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement; // first element of the bag
    private int size; // size of bag

    private static class Node<Element> {

        private Element content;
        private Node<Element> nextElement;
    }

    /**
     * Create an empty bag
     */
    public Bag() {
        firstElement = null;
        size = 0;
    }

    /**
     * @return true if this bag is empty, false otherwise
     */
    public boolean isEmpty() {
        return firstElement == null;
    }

    /**
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * @param element - the element to add
     */
    //添加元素时，都新建一个节点，内容就是元素的值，下一个元素存上次的节点数据（有点类似树形结构和链表）
    public void add(Element element) {
        Node<Element> oldfirst = firstElement;
        firstElement = new Node<>();
        //外部类可以直接访问内部类的私有属性
        firstElement.content = element;
        firstElement.nextElement = oldfirst;
        size++;
    }

    /**
     * Checks if the bag contains a specific element
     *
     * @param element which you want to look for
     * @return true if bag contains element, otherwise false
     */
    public boolean contains(Element element) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return an iterator that iterates over the elements in this bag in
     * arbitrary order
     */
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")
    private class ListIterator<Element> implements Iterator<Element> {

        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement) {
            currentElement = firstElement;
        }

        public boolean hasNext() {
            return currentElement != null;
        }

        /**
         * remove is not allowed in a bag
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Element next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }

    /**
     * main-method for testing
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("4");
        bag.add("1");
        bag.add("1");
        bag.add("2");

        System.out.println("size of bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }

        System.out.println(bag.contains(null));
        System.out.println(bag.contains("1"));
        System.out.println(bag.contains("3"));

        //使用foreach遍历
        bag.forEach(it -> {
            System.out.println(it);
        });
    }
}
