package net.malanius.md2moin.core.tables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableConverterImplTest {

    private TableConverter converter;

    @Before
    public void setUp() {
        converter = new TableConverterImpl();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void convertTable() {
        //TODO implement table conversion test
        //fail("Not implemented yet");
        String input = "not implemented";
        String expected = "not implemented";

        assertEquals(expected, converter.convertTable(input));
    }
}
