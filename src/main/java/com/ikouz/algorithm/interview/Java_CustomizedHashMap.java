package com.ikouz.algorithm.interview;

public class Java_CustomizedHashMap<K, V> {

    public Java_CustomizedHashMap() {
        _arr = new Node[_capacity];
    }

    static class Node<K, V> {
        final int hash;
        final K k;
        V v;
        Node next;

        Node(int hash, K k, V v) {
            this.hash = hash;
            this.k = k;
            this.v = v;
        }
    }

    private Node[] _arr;
    private int _capacity = 8;
    private int _size = 0;

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        Node entry = new Node(getIndex(key), key, value);
        int index = getIndex(key);
        // check conflict
        Node currentNode = _arr[index];
        if (currentNode == null) {
            _arr[index] = entry;
            _size++;
        } else {
            // find the tail of the list and append
            while (currentNode.next != null) {
                if (currentNode.k.equals(entry.k)) {
                    entry.v = currentNode.v;
                    return;
                } else {
                    currentNode = currentNode.next;
                    _size++;
                }
            }
            currentNode.next = entry;
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % _capacity;
    }
}
