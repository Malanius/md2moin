package net.malanius.md2moin.core;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.core.codeblocks.CodeBlockConverter;
import net.malanius.md2moin.core.emphasis.EmphasisConverter;
import net.malanius.md2moin.core.headers.HeaderConverter;
import net.malanius.md2moin.core.lists.ListConverter;
import net.malanius.md2moin.core.tables.TableConverter;
import net.malanius.md2moin.core.links.LinkConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConverterImpl implements Converter {

    private final EmphasisConverter emphasisConverter;
    private final HeaderConverter headerConverter;
    private final ListConverter listConverter;
    private final CodeBlockConverter codeblockConverter;
    private final TableConverter tableConverter;
    private final LinkConverter linkConverter;

    @Autowired
    public ConverterImpl(EmphasisConverter emphasisConverter, HeaderConverter headerConverter, ListConverter listConverter, CodeBlockConverter codeBlockConverter, TableConverter tableConverter, LinkConverter linkConverter) {
        this.emphasisConverter = emphasisConverter;
        this.headerConverter = headerConverter;
        this.listConverter = listConverter;
        this.codeblockConverter = codeBlockConverter;
        this.tableConverter = tableConverter;
        this.linkConverter = linkConverter;
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
        converted = emphasisConverter.convertBold(converted);
        converted = emphasisConverter.convertItalics(converted);
        converted = emphasisConverter.convertStrikethrough(converted);
        converted = listConverter.convertUnorderedList(converted);
        converted = listConverter.convertOrderedList(converted);
        converted = codeblockConverter.convertCodeBlock(converted);
        converted = codeblockConverter.convertInlineCode(converted);
        converted = tableConverter.convertTable(converted);
        converted = linkConverter.convertLink(converted);
        return converted;
    }

}
