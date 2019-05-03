package net.malanius.md2moin.core;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.core.emphasis.EmphasisConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ConverterImpl implements Converter {

    private final EmphasisConverter emphasisConverter;

    @Autowired
    public ConverterImpl(EmphasisConverter emphasisConverter) {
        this.emphasisConverter = emphasisConverter;
    }

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
        converted = emphasisConverter.convertBold(converted);
        converted = emphasisConverter.convertItalics(converted);
        converted = emphasisConverter.convertStrikethrough(converted);
        converted = convertCodeBlock(converted);
        converted = convertInlineCode(converted);
        converted = convertTable(converted);
        return converted;
    }

    public String convertH1(String input) {
        log.trace("convertH1()");

        Pattern h1pattern = Pattern.compile(Constants.H1_FIND, Pattern.MULTILINE);
        Matcher h1matcher = h1pattern.matcher(input);
        return h1matcher.replaceAll(Constants.H1_REPLACE);
    }

    public String convertH2(String input) {
        log.trace("convertH2()");

        Pattern h2pattern = Pattern.compile(Constants.H2_FIND, Pattern.MULTILINE);
        Matcher h2matcher = h2pattern.matcher(input);
        return h2matcher.replaceAll(Constants.H2_REPLACE);
    }

    public String convertH3(String input) {
        log.trace("convertH3()");

        Pattern h3pattern = Pattern.compile(Constants.H3_FIND, Pattern.MULTILINE);
        Matcher h3matcher = h3pattern.matcher(input);
        return h3matcher.replaceAll(Constants.H3_REPLACE);
    }

    public String convertH4(String input) {
        log.trace("convertH4()");

        Pattern h4pattern = Pattern.compile(Constants.H4_FIND, Pattern.MULTILINE);
        Matcher h4matcher = h4pattern.matcher(input);
        return h4matcher.replaceAll(Constants.H4_REPLACE);
    }

    public String convertH5(String input) {
        log.trace("convertH5()");

        Pattern h5pattern = Pattern.compile(Constants.H5_FIND, Pattern.MULTILINE);
        Matcher h5matcher = h5pattern.matcher(input);
        return h5matcher.replaceAll(Constants.H5_REPLACE);
    }

    public String convertUnorderedList(String input) {
        log.trace("convertUnorderedList()");

        Pattern unorderedListPattern = Pattern.compile(Constants.UNORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(Constants.UNORDERED_LIST_REPLACE);
    }

    public String convertOrderedList(String input) {
        log.trace("convertOrderedList()");

        Pattern orderedListPattern = Pattern.compile(Constants.ORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(Constants.ORDERED_LIST_REPLACE);
    }

    public String convertCodeBlock(String input) {
        log.trace("convertCodeBlock()");

        Pattern codeBlockStartPattern = Pattern.compile(Constants.CODE_BLOCK_START_FIND, Pattern.MULTILINE);
        Matcher codeBlockStartMatcher = codeBlockStartPattern.matcher(input);
        String temp = codeBlockStartMatcher.replaceAll(Constants.CODE_BLOCK_START_REPLACE);

        Pattern codeBlockEndPattern = Pattern.compile(Constants.CODE_BLOCK_END_FIND, Pattern.MULTILINE);
        Matcher codeBlockEndMatcher = codeBlockEndPattern.matcher(temp);
        return codeBlockEndMatcher.replaceAll(Constants.CODE_BLOCK_END_REPLACE
        );
    }

    public String convertInlineCode(String input) {
        log.trace("convertInlineCode()");

        Pattern unorderedListPattern = Pattern.compile(Constants.INLINE_CODE_FIND);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(Constants.INLINE_CODE_REPLACE);
    }

    public String convertTable(String input) {
        log.trace("convertTable()");

        //TODO implement table conversion
        return input;
    }
}
