package stringarray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringArrayTest {

    private StringArray stringArray;

    @Before
    public void setUp() throws Exception {
        this.stringArray = new StringArray(5);

        this.stringArray.add("eins");
        this.stringArray.add("zwei");
        this.stringArray.add("drei");
        this.stringArray.add("vier");
        this.stringArray.add("fünf");
    }

    @After
    public void tearDown() throws Exception {
        this.stringArray = null;
    }

    @Test
    public void get() {
        assertEquals("vier", this.stringArray.get(3));
    }

    @Test
    public void set() {
        String previous = this.stringArray.get(2);
        this.stringArray.set(2, "acht");
        assertNotEquals(previous, this.stringArray.get(2));
    }

    @Test
    public void length() {
        assertEquals(5, this.stringArray.length());
    }

    @Test
    public void remove() {
        int length = this.stringArray.length();
        this.stringArray.remove(0);
        assertEquals(length - 1, this.stringArray.length());
    }

    @Test
    public void add() {
        int index = this.stringArray.add("sechs");
        assertEquals("sechs", this.stringArray.get(index));
    }

    @Test
    public void resize() {
        int length = this.stringArray.length();
        for (int i = 0; i < 100; i++) {
            this.stringArray.add("test");
        }
        assertEquals(length + 100, this.stringArray.length());
    }
}