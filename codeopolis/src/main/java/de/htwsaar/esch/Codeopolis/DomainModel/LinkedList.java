package de.htwsaar.esch.Codeopolis.DomainModel;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        this.size++;
    }

    public T removeFirst() {
        if (this.isEmpty()) return null;

        Node<T> cached = this.head;
        this.head = this.head.next;
        cached.next = null;

        this.size--;

        return cached.data;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = this.head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = this.head;
        for (int i = 0; i < index; i++)
            current = current.next;

        T oldData = current.data;
        current.data = data;

        return oldData;
    }

    public void clear() {
        // alternative, die auch alle referenzen cleared, aber ist in O(n)
//        for (int i = 0; i < this.size; i++)
//            this.removeFirst();

        this.head = null;
        this.size = 0;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) return this.removeFirst();

        Node<T> current = this.head;
        for (int i = 0; i < index - 1; i++)
            current = current.next;

        Node<T> cached = current.next;
        current.next = cached.next;
        cached.next = null;

        this.size--;

        return cached.data;
    }

    public void remove(T data) {
        if (this.isEmpty()) return;

        if (this.head.data.equals(data)) {
            this.removeFirst();
            return;
        }

        Node<T> current = this.head;
        while (current.next != null && !current.next.data.equals(data))
            current = current.next;

        if (current.next != null) {
            Node<T> cached = current.next;
            current.next = cached.next;
            cached.next = null;
            this.size--;
        }
    }

    public void addAll(LinkedList<T> other) {
        if (other == null || other.isEmpty()) return;

        Node<T> current = other.head;
        while (current != null) {
            this.addLast(current.data);
            current = current.next;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> other = (LinkedList<?>) o;
        return this.size == other.size && Objects.equals(this.head, other.head);
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> other = (Node<?>) o;
            return Objects.equals(this.data, other.data) && Objects.equals(this.next, other.next);
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> currentNode;
        private T nextData;

        private LinkedListIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            this.nextData = null;

            if (this.currentNode != null) {
                this.nextData = this.currentNode.data;
                this.currentNode = this.currentNode.next;
            }

            return this.nextData != null;
        }

        @Override
        public T next() {
            return this.nextData;
        }
    }

}
