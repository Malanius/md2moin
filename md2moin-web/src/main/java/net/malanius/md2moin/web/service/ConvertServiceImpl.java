package net.malanius.md2moin.web.service;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.core.Converter;
import net.malanius.md2moin.web.entity.ConvertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConvertServiceImpl implements ConvertService {

    private final Converter converter;

    @Autowired
    public ConvertServiceImpl(Converter converter) {
        this.converter = converter;
    }

    @Override
    public String convert(ConvertRequest request) {
        return converter.convertToMoin(request.getMdText(), request.getOffset());
    }
}
