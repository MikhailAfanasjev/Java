package ru.vsu.cs.course1;

import java.util.Comparator;

class MyPriorityQueue<T> {
    private Node first;
    private Comparator<T> c;
    private int size;

    MyPriorityQueue(Comparator<T> c) {
        if (c != null) {
            this.c = c;
        } else {
            throw new IllegalArgumentException("Comparator not may be null...");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean offer(T value) {
        boolean result;
        if (result = value != null) {
            if (this.size == 0) {
                this.first = new Node(value);
            } else {
                Node last = null;
                for (Node node = this.first; node != null; node = node.next) {
                    if (this.c.compare(node.value, value) >= 0) {
                        break;
                    }
                    last = node;
                }
                if (last == null) {
                    Node first = new Node(value);
                    first.next = this.first;
                    this.first = first;
                } else {
                    Node temp = last.next;
                    last.next = new Node(value);
                    last.next.next = temp;
                }
            }
            this.size++;
        }
        return result;
    }

    public T peek() {
        return this.size() == 0 ? null : this.first.value;
    }

    public T poll() {
        T first = null;
        if (this.size() > 0) {
            first = this.first.value;
            this.first = this.first.next;
            size--;
        }
        return first;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int count = 0;
        for (Node node = this.first; node != null; node = node.next) {
            sb.append(node.value);
            if (count++ < this.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    private class Node {
        private Node next;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }
}
