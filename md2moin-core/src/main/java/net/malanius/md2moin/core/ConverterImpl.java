package net.malanius.md2moin.core;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.core.emphasis.EmphasisConverter;
import net.malanius.md2moin.core.headers.HeaderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ConverterImpl implements Converter {

    private final EmphasisConverter emphasisConverter;
    private final HeaderConverter headerConverter;

    @Autowired
    public ConverterImpl(EmphasisConverter emphasisConverter, HeaderConverter headerConverter) {
        this.emphasisConverter = emphasisConverter;
        this.headerConverter = headerConverter;
    }

    @Override
    public String convertToMoin(String input) {
        return convertToMoin(input, 0);
    }

    @Override
    public String convertToMoin(String input, int headingOffset) {
        log.trace("convertToMoin(offset: {}", headingOffset);

        String converted = headerConverter.convertH1(input);
        converted = headerConverter.convertH2(converted);
        converted = headerConverter.convertH3(converted);
        converted = headerConverter.convertH4(converted);
        converted = headerConverter.convertH5(converted);
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
