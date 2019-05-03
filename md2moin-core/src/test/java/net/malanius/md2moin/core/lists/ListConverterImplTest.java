package net.malanius.md2moin.core.lists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListConverterImplTest {

    private ListConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new ListConverterImpl();
    }

    @After
    public void tearDown() throws Exception {
        converter = null;
    }

    @Test
    public void convertUnorderedList() {
        String input = "- item level 1\n"
                + "  - item level 2\n"
                + "    - item level 3";
        String expected = " * item level 1\n"
                + "   * item level 2\n"
                + "     * item level 3";

        assertEquals(expected, converter.convertUnorderedList(input));
    }

    @Test
    public void convertOrderedList() {
        String input = "1. level 1\n"
                + "   1. level 2\n"
                + "      1. level 3";

        String expected = " 1. level 1\n"
                + "    1. level 2\n"
                + "       1. level 3";

        assertEquals(expected, converter.convertOrderedList(input));
    }
}
