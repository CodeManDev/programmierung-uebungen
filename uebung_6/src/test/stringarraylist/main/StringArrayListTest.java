package stringarraylist.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringArrayListTest {

    private StringArrayList stringArrayList;

    @Before
    public void setUp() throws Exception {
        this.stringArrayList = new StringArrayList();

        this.stringArrayList.add("eins");
        this.stringArrayList.add("zwei");
        this.stringArrayList.add("drei");
        this.stringArrayList.add("vier");
        this.stringArrayList.add("fünf");
    }

    @After
    public void tearDown() throws Exception {
        this.stringArrayList = null;
    }

    @Test
    public void add() {
        this.stringArrayList.add("sechs");
        assertTrue(this.stringArrayList.contains("sechs"));
    }

    @Test
    public void get() {
        assertEquals("vier", this.stringArrayList.get(3));
    }

    @Test
    public void set() {
        String previous = this.stringArrayList.get(2);
        this.stringArrayList.set(2, "acht");
        assertNotEquals(previous, this.stringArrayList.get(2));
    }

    @Test
    public void remove() {
        int length = this.stringArrayList.length();
        this.stringArrayList.remove(0);
        assertEquals(length - 1, this.stringArrayList.length());
    }

    @Test
    public void length() {
        assertEquals(5, this.stringArrayList.length());
    }

    @Test
    public void contains() {
        assertTrue(this.stringArrayList.contains("vier"));
        assertFalse(this.stringArrayList.contains("sieben"));
    }

    @Test
    public void clear() {
        this.stringArrayList.clear();
        assertEquals(0, this.stringArrayList.length());
    }

    @Test
    public void toArray() {
        assertArrayEquals(new String[]{"eins", "zwei", "drei", "vier", "fünf"}, this.stringArrayList.toArray());
    }

    @Test
    public void isEmpty() {
        assertFalse(this.stringArrayList.isEmpty());
        this.stringArrayList.clear();
        assertTrue(this.stringArrayList.isEmpty());
    }
}