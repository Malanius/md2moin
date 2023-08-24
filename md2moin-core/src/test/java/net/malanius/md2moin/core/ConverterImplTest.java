package net.malanius.md2moin.core;

import net.malanius.md2moin.core.codeblocks.CodeBlockConverterImpl;
import net.malanius.md2moin.core.emphasis.EmphasisConverterImpl;
import net.malanius.md2moin.core.headers.HeaderConverterImpl;
import net.malanius.md2moin.core.lists.ListConverterImpl;
import net.malanius.md2moin.core.tables.TableConverterImpl;
import net.malanius.md2moin.core.links.LinkConverterImpl;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ConverterImplTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new ConverterImpl(
                new EmphasisConverterImpl(),
                new HeaderConverterImpl(),
                new ListConverterImpl(),
                new CodeBlockConverterImpl(),
                new TableConverterImpl(),
                new LinkConverterImpl());
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
    public void fullConversionTest() throws IOException {
        String input = IOUtils.toString(Objects.requireNonNull(
                this.getClass().getClassLoader().getResourceAsStream("test.md")), StandardCharsets.UTF_8);
        String expected = IOUtils.toString(Objects.requireNonNull(
                this.getClass().getClassLoader().getResourceAsStream("test.moin")), StandardCharsets.UTF_8);

        assertEquals(expected, converter.convertToMoin(input));
    }

}
