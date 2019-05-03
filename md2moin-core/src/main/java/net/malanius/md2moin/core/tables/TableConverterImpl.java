package net.malanius.md2moin.core.tables;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TableConverterImpl implements TableConverter {

    @Override
    public String convertTable(String input) {
        log.trace("convertTable()");

        //TODO implement table conversion
        return input;
    }
}
