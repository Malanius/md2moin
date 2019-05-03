package net.malanius.md2moin.core.links;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkConverterImplTest {

    private LinkConverter converter;

    @Before
    public void setUp() {
        converter = new LinkConverterImpl();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void convertLink() {
        String input = "This is some text with [Example](https://example.com) link. And yet [another](www.example.com) one.\n"
                + "This is [link](http://example.com) on another line.";
        String expected = "This is some text with [[https://example.com|Example]] link. And yet [[www.example.com|another]] one.\n"
                + "This is [[http://example.com|link]] on another line.";

        assertEquals(expected, converter.convertLink(input));
    }
}
