package net.malanius.md2moin.core;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.core.codeblocks.CodeblockConverter;
import net.malanius.md2moin.core.emphasis.EmphasisConverter;
import net.malanius.md2moin.core.headers.HeaderConverter;
import net.malanius.md2moin.core.lists.ListConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConverterImpl implements Converter {

    private final EmphasisConverter emphasisConverter;
    private final HeaderConverter headerConverter;
    private final ListConverter listConverter;
    private final CodeblockConverter codeblockConverter;

    @Autowired
    public ConverterImpl(EmphasisConverter emphasisConverter, HeaderConverter headerConverter, ListConverter listConverter, CodeblockConverter codeblockConverterl) {
        this.emphasisConverter = emphasisConverter;
        this.headerConverter = headerConverter;
        this.listConverter = listConverter;
        this.codeblockConverter = codeblockConverterl;
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
        converted = listConverter.convertUnorderedList(converted);
        converted = listConverter.convertOrderedList(converted);
        converted = emphasisConverter.convertBold(converted);
        converted = emphasisConverter.convertItalics(converted);
        converted = emphasisConverter.convertStrikethrough(converted);
        converted = codeblockConverter.convertCodeBlock(converted);
        converted = codeblockConverter.convertInlineCode(converted);
        converted = convertTable(converted);
        return converted;
    }

    public String convertTable(String input) {
        log.trace("convertTable()");

        //TODO implement table conversion
        return input;
    }
}
