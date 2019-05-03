package net.malanius.md2moin.core;

import net.malanius.md2moin.core.emphasis.EmphasisConverterImpl;
import net.malanius.md2moin.core.headers.HeaderConverterImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterImplTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new ConverterImpl(
                new EmphasisConverterImpl(),
                new HeaderConverterImpl());
    }

    @After
    public void tearDown() {
        converter = null;
    }



    @Test
    public void convertMultipleHeadings() {
        String input = "# H1\n"
                + "\n"
                + "## H2\n"
                + "\n"
                + "### H3\n"
                + "\n"
                + "#### H4\n"
                + "\n"
                + "##### H5";
        String expected = "= H1 =\n"
                + "\n"
                + "== H2 ==\n"
                + "\n"
                + "=== H3 ===\n"
                + "\n"
                + "==== H4 ====\n"
                + "\n"
                + "===== H5 =====";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertUnorderedList() {
        String input = "- item level 1\n"
                + "  - item level 2\n"
                + "    - item level 3";
        String expected = " * item level 1\n"
                + "   * item level 2\n"
                + "     * item level 3";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertOrderedList() {
        String input = "1. level 1\n"
                + "   1. level 2\n"
                + "      1. level 3";

        String expected = " 1. level 1\n"
                + "    1. level 2\n"
                + "       1. level 3";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertBoldItalicsCombined() {
        String input = "Some **bold text with *italic* inside**.\nSome **bold text with *italic* inside**.";
        String expected = "Some '''bold text with ''italic'' inside'''.\nSome '''bold text with ''italic'' inside'''.";

        assertEquals(expected, converter.convertToMoin(input));
    }


    @Test
    public void convertBoldItalicsTogether() {
        String input = "Some ***bold italic text with inside***.\nSome ***bold italic text with inside***.";
        String expected = "Some '''''bold italic text with inside'''''.\nSome '''''bold italic text with inside'''''.";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertInlineCode() {
        String input = "Some text with `inline code` inserted.\nSome text with `inline code` inserted.";
        String expected = "Some text with {inline code} inserted.\nSome text with {inline code} inserted.";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertCodeBlock() {
        String input = "```bash\n"
                + "#!/bin/bash\n"
                + "echo test\n"
                + "```";
        String expected = "{{{#!highlight bash\n"
                + "#!/bin/bash\n"
                + "echo test\n"
                + "}}}";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertTable() {
        //TOTO implement table conversion test
        //fail("Not implemented yet");
    }
}
