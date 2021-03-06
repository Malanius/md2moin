package net.malanius.md2moin.core.codeblocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodeBlockConverterImplTest {

    private CodeBlockConverter converter;

    @Before
    public void setUp() {
        converter = new CodeBlockConverterImpl();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void convertInlineCode() {
        String input = "Some text with `inline code` inserted.\nSome text with `inline code` inserted.";
        String expected = "Some text with {{{inline code}}} inserted.\nSome text with {{{inline code}}} inserted.";

        assertEquals(expected, converter.convertInlineCode(input));
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

        assertEquals(expected, converter.convertCodeBlock(input));
    }
}
