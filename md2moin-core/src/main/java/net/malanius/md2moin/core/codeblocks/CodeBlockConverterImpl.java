package net.malanius.md2moin.core.codeblocks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class CodeBlockConverterImpl implements CodeblockConverter {

    @Override
    public String convertCodeBlock(String input) {
        log.trace("convertCodeBlock()");

        Pattern codeBlockStartPattern = Pattern.compile(CodeBlockConstants.CODE_BLOCK_START_FIND, Pattern.MULTILINE);
        Matcher codeBlockStartMatcher = codeBlockStartPattern.matcher(input);
        String temp = codeBlockStartMatcher.replaceAll(CodeBlockConstants.CODE_BLOCK_START_REPLACE);

        Pattern codeBlockEndPattern = Pattern.compile(CodeBlockConstants.CODE_BLOCK_END_FIND, Pattern.MULTILINE);
        Matcher codeBlockEndMatcher = codeBlockEndPattern.matcher(temp);
        return codeBlockEndMatcher.replaceAll(CodeBlockConstants.CODE_BLOCK_END_REPLACE
        );
    }

    @Override
    public String convertInlineCode(String input) {
        log.trace("convertInlineCode()");

        Pattern unorderedListPattern = Pattern.compile(CodeBlockConstants.INLINE_CODE_FIND);
        Matcher unorderedListMatcher = unorderedListPattern.matcher(input);
        return unorderedListMatcher.replaceAll(CodeBlockConstants.INLINE_CODE_REPLACE);
    }

}
