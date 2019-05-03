package net.malanius.md2moin.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConverterImplTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new ConverterImpl();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void convertH1NoOffset() {
        assertEquals("= H1 =", converter.convertToMoin("# H1"));
    }

    @Test
    public void convertH2NoOffset() {
        assertEquals("== H2 ==", converter.convertToMoin("## H2"));
    }

    @Test
    public void convertH3NoOffset() {
        assertEquals("=== H3 ===", converter.convertToMoin("### H3"));
    }

    @Test
    public void convertH4NoOffset() {
        assertEquals("==== H4 ====", converter.convertToMoin("#### H4"));
    }

    @Test
    public void convertH5NoOffset() {
        assertEquals("===== H5 =====", converter.convertToMoin("##### H5"));
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
    public void convertOrderedList(){
        String input = "1. level 1\n"
                + "   1. level 2\n"
                + "      1. level 3";

        String expected = " 1. level 1\n"
                + "    1. level 2\n"
                + "       1. level 3";

        assertEquals(expected, converter.convertToMoin(input));
    }

    @Test
    public void convertItalics(){
        String input = "Some text with *italics* inside. And yet *another* occurrence.\nAnd yet *another* occurrence.";
        String expected = "Some text with ''italics'' inside. And yet ''another'' occurrence.\nAnd yet ''another'' occurrence.";

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
    public void convertTable(){
        //TOTO implement table conversion test
        //fail("Not implemented yet");
    }
}
