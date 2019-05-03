package net.malanius.md2moin.core.headers;

public interface HeaderConverter {
    String convertH1(String input);

    String convertH2(String input);

    String convertH3(String input);

    String convertH4(String input);

    String convertH5(String input);
}
