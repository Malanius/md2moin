package net.malanius.md2moin.core.lists;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ListConverterImpl implements ListConverter {

    @Override
    public String convertUnorderedList(String input) {
        log.trace("convertUnorderedList()");

        Pattern unorderedListPattern = Pattern.compile(ListConstants.UNORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(ListConstants.UNORDERED_LIST_REPLACE);
    }

    @Override
    public String convertOrderedList(String input) {
        log.trace("convertOrderedList()");

        Pattern orderedListPattern = Pattern.compile(ListConstants.ORDERED_LIST_FIND, Pattern.MULTILINE);
        Matcher orderedListMatcher = orderedListPattern.matcher(input);
        return orderedListMatcher.replaceAll(ListConstants.ORDERED_LIST_REPLACE);
    }
}
