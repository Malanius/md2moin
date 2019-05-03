package net.malanius.md2moin.core.headers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeaderConverterImplTest {

    private HeaderConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new HeaderConverterImpl();
    }

    @After
    public void tearDown() throws Exception {
        converter = null;
    }

    @Test
    public void convertH1NoOffset() {
        assertEquals("= H1 =", converter.convertH1("# H1"));
    }

    @Test
    public void convertH2NoOffset() {
        assertEquals("== H2 ==", converter.convertH2("## H2"));
    }

    @Test
    public void convertH3NoOffset() {
        assertEquals("=== H3 ===", converter.convertH3("### H3"));
    }

    @Test
    public void convertH4NoOffset() {
        assertEquals("==== H4 ====", converter.convertH4("#### H4"));
    }

    @Test
    public void convertH5NoOffset() {
        assertEquals("===== H5 =====", converter.convertH5("##### H5"));
    }
}
