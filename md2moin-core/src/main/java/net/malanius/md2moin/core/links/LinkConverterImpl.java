package net.malanius.md2moin.core.links;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class LinkConverterImpl implements LinkConverter {

    @Override
    public String convertLink(String input) {
        log.trace("convertLink()");

        Pattern unorderedListPattern = Pattern.compile(LinkConstants.LINK_FIND, Pattern.MULTILINE);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(LinkConstants.LINK_REPLACE);
    }

}
