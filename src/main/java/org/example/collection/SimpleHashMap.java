package org.example.collection;

class SimpleHashMap<K, V> {
    private static final int CAPACITY = 16;

    private Node<K, V>[] table;

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        table = (Node<K, V>[]) new Node[CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        //table[index]设置为next的意义在于 如果发生哈希碰撞时就把当前新创建的值放在头部，把旧值设置到next节点
        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    private int hash(K key) {
//        return (key.hashCode() & 0x7FFFFFFF) % CAPACITY;
        //模拟哈希冲突时值追加链表
        return 1;
    }

    // 简单测试
    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("One", 5);

        System.out.println(map.get("Two")); // 输出: 2
        System.out.println(map.get("Four")); // 输出: null
    }
}
