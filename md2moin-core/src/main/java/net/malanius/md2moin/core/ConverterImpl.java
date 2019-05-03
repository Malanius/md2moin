package net.malanius.md2moin.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class ConverterImpl implements Converter {

    @Override
    public String convertToMoin(String input) {
        return convertToMoin(input, 0);
    }

    @Override
    public String convertToMoin(String input, int headingOffset) {
        log.trace("convertToMoin(offset: {}", headingOffset);

        String converted = convertH1(input);
        converted = convertH2(converted);
        converted = convertH3(converted);
        converted = convertH4(converted);
        converted = convertH5(converted);
        converted = convertUnorderedList(converted);
        converted = convertOrderedList(converted);
        converted = convertBold(converted);
        converted = convertItalics(converted);
        converted = convertCodeBlock(converted);
        converted = convertInlineCode(converted);
        converted = convertTable(converted);
        return converted;
    }

    private String convertH1(String input) {
        log.trace("convertH1()");

        Pattern h1pattern = Pattern.compile(Constants.H1_FIND, Pattern.MULTILINE);
        Matcher h1matcher = h1pattern.matcher(input);
        return h1matcher.replaceAll(Constants.H1_REPLACE);
    }

    private String convertH2(String input) {
        log.trace("convertH2()");

        Pattern h2pattern = Pattern.compile(Constants.H2_FIND, Pattern.MULTILINE);
        Matcher h2matcher = h2pattern.matcher(input);
        return h2matcher.replaceAll(Constants.H2_REPLACE);
    }

    private String convertH3(String input) {
        log.trace("convertH3()");

        Pattern h3pattern = Pattern.compile(Constants.H3_FIND, Pattern.MULTILINE);
        Matcher h3matcher = h3pattern.matcher(input);
        return h3matcher.replaceAll(Constants.H3_REPLACE);
    }

    private String convertH4(String input) {
        log.trace("convertH4()");

        Pattern h4pattern = Pattern.compile(Constants.H4_FIND, Pattern.MULTILINE);
        Matcher h4matcher = h4pattern.matcher(input);
        return h4matcher.replaceAll(Constants.H4_REPLACE);
    }

    private String convertH5(String input) {
        log.trace("convertH5()");

        Pattern h5pattern = Pattern.compile(Constants.H5_FIND, Pattern.MULTILINE);
        Matcher h5matcher = h5pattern.matcher(input);
        return h5matcher.replaceAll(Constants.H5_REPLACE);
    }

    private String convertUnorderedList(String input) {
        log.trace("convertUnorderedList()");

        Pattern unorderedListPattern = Pattern.compile(Constants.UNORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(Constants.UNORDERED_LIST_REPLACE);
    }

    private String convertOrderedList(String input) {
        log.trace("convertOrderedList()");

        Pattern orderedListPattern = Pattern.compile(Constants.ORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(Constants.ORDERED_LIST_REPLACE);
    }

    private String convertBold(String input) {
        log.trace("convertBold()");

        Pattern orderedListPattern = Pattern.compile(Constants.BOLD_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(Constants.BOLD_REPLACE);
    }

    private String convertItalics(String input) {
        log.trace("convertOrderedList()");

        Pattern orderedListPattern = Pattern.compile(Constants.ITALICS_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(Constants.ITALICS_REPLACE);
    }

    private String convertCodeBlock(String input) {
        log.trace("convertCodeBlock()");

        Pattern codeBlockStartPattern = Pattern.compile(Constants.CODE_BLOCK_START_FIND, Pattern.MULTILINE);
        Matcher codeBlockStartMatcher = codeBlockStartPattern.matcher(input);
        String temp = codeBlockStartMatcher.replaceAll(Constants.CODE_BLOCK_START_REPLACE);

        Pattern codeBlockEndPattern = Pattern.compile(Constants.CODE_BLOCK_END_FIND, Pattern.MULTILINE);
        Matcher codeBlockEndMatcher = codeBlockEndPattern.matcher(temp);
        return codeBlockEndMatcher.replaceAll(Constants.CODE_BLOCK_END_REPLACE
        );
    }

    private String convertInlineCode(String input) {
        log.trace("convertInlineCode()");

        Pattern unorderedListPattern = Pattern.compile(Constants.INLINE_CODE_FIND);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(Constants.INLINE_CODE_REPLACE);
    }

    private String convertTable(String input) {
        log.trace("convertTable()");

        //TODO implement table conversion
        return input;
    }
}
