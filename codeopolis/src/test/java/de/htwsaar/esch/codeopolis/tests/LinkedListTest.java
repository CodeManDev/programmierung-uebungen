package de.htwsaar.esch.codeopolis.tests;

import de.htwsaar.esch.Codeopolis.DomainModel.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addLast() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void removeFirst() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        String removed = list.removeFirst();

        assertEquals("A", removed);
        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    void isEmpty() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addLast("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void size() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());

        list.addLast("A");
        assertEquals(1, list.size());

        list.addLast("B");
        assertEquals(2, list.size());
    }

    @Test
    void get() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
        });
    }

    @Test
    void set() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        list.set(1, "X");

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("C", list.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(3, "Y");
        });
    }

    @Test
    void clear() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void remove() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(3);
        });
    }

    @Test
    void addAll() {
        LinkedList<String> list1 = new LinkedList<>();
        list1.addLast("A");
        list1.addLast("B");

        LinkedList<String> list2 = new LinkedList<>();
        list2.addLast("C");
        list2.addLast("D");

        list1.addAll(list2);

        assertEquals(4, list1.size());
        assertEquals("A", list1.get(0));
        assertEquals("B", list1.get(1));
        assertEquals("C", list1.get(2));
        assertEquals("D", list1.get(3));
    }

    @Test
    void testEquals() {
        LinkedList<String> list1 = new LinkedList<>();
        list1.addLast("A");
        list1.addLast("B");

        LinkedList<String> list2 = new LinkedList<>();
        list2.addLast("A");
        list2.addLast("B");

        assertEquals(list1, list2);

        list2.addLast("C");
        assertNotEquals(list1, list2);

        assertNotEquals(null, list1);
    }
}