package net.malanius.md2moin.core.emphasis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmphasisConverterImplTest {

    private EmphasisConverter converter;

    @Before
    public void setUp() {
        converter = new EmphasisConverterImpl();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void convertItalics() {
        String input = "Some text with *italics* inside. And yet *another* occurrence.\nAnd yet *another* occurrence.";
        String expected = "Some text with ''italics'' inside. And yet ''another'' occurrence.\nAnd yet ''another'' occurrence.";

        assertEquals(expected, converter.convertItalics(input));
    }

    @Test
    public void convertBold() {
        String input = "Some text with **bold** inside. And yet **another** occurrence.\nAnd yet **another** occurrence.";
        String expected = "Some text with '''bold''' inside. And yet '''another''' occurrence.\nAnd yet '''another''' occurrence.";

        assertEquals(expected, converter.convertBold(input));
    }

    @Test
    public void convertStrikethrough() {
        String input = "Some text with ~~strikethrough~~ inside. And yet ~~another~~ occurrence.\nAnd yet ~~another~~ occurrence.";
        String expected = "Some text with --(strikethrough)-- inside. And yet --(another)-- occurrence.\nAnd yet --(another)-- occurrence.";

        assertEquals(expected, converter.convertStrikethrough(input));
    }

}
