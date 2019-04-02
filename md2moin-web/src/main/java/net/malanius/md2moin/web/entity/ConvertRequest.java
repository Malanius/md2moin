package net.malanius.md2moin.web.entity;

import lombok.Data;

@Data
public class ConvertRequest {

    private String mdText;
    private int offset;

}
