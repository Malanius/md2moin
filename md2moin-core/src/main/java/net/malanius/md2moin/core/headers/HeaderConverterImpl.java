package net.malanius.md2moin.core.headers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class HeaderConverterImpl implements HeaderConverter {

    @Override
    public String convertH1(String input) {
        log.trace("convertH1()");

        Pattern h1pattern = Pattern.compile(HeaderConstants.H1_FIND, Pattern.MULTILINE);
        Matcher h1matcher = h1pattern.matcher(input);
        return h1matcher.replaceAll(HeaderConstants.H1_REPLACE);
    }

    @Override
    public String convertH2(String input) {
        log.trace("convertH2()");

        Pattern h2pattern = Pattern.compile(HeaderConstants.H2_FIND, Pattern.MULTILINE);
        Matcher h2matcher = h2pattern.matcher(input);
        return h2matcher.replaceAll(HeaderConstants.H2_REPLACE);
    }

    @Override
    public String convertH3(String input) {
        log.trace("convertH3()");

        Pattern h3pattern = Pattern.compile(HeaderConstants.H3_FIND, Pattern.MULTILINE);
        Matcher h3matcher = h3pattern.matcher(input);
        return h3matcher.replaceAll(HeaderConstants.H3_REPLACE);
    }

    @Override
    public String convertH4(String input) {
        log.trace("convertH4()");

        Pattern h4pattern = Pattern.compile(HeaderConstants.H4_FIND, Pattern.MULTILINE);
        Matcher h4matcher = h4pattern.matcher(input);
        return h4matcher.replaceAll(HeaderConstants.H4_REPLACE);
    }

    @Override
    public String convertH5(String input) {
        log.trace("convertH5()");

        Pattern h5pattern = Pattern.compile(HeaderConstants.H5_FIND, Pattern.MULTILINE);
        Matcher h5matcher = h5pattern.matcher(input);
        return h5matcher.replaceAll(HeaderConstants.H5_REPLACE);
    }
}
