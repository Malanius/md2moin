package net.malanius.md2moin.core.emphasis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class EmphasisConverterImpl implements EmphasisConverter {

    @Override
    public String convertBold(String input) {
        log.trace("convertBold()");

        Pattern orderedListPattern = Pattern.compile(EmphasisConstants.BOLD_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(EmphasisConstants.BOLD_REPLACE);
    }

    @Override
    public String convertItalics(String input) {
        log.trace("convertItalics()");

        Pattern orderedListPattern = Pattern.compile(EmphasisConstants.ITALICS_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(EmphasisConstants.ITALICS_REPLACE);
    }

    @Override
    public String convertStrikethrough(String input) {
        log.trace("convertStrikethrough()");

        Pattern orderedListPattern = Pattern.compile(EmphasisConstants.STRIKETHROUGH_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(EmphasisConstants.STRIKETHROUGH_REPLACE);
    }

}
