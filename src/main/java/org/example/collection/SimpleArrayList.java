package org.example.collection;

import java.util.Arrays;

public class SimpleArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public SimpleArrayList(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add (T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public T get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size ==  array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public static void main(String[] args) {
        SimpleArrayList<String> simpleList = new SimpleArrayList<>();
        simpleList.add("array1");
        simpleList.add("array2");
        simpleList.add("array3");

        System.out.println("Elements in the list:");
        for (int i = 0; i < simpleList.size(); i++) {
            System.out.println(simpleList.get(i));
        }
    }

}
