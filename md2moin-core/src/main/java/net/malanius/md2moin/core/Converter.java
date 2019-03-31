package net.malanius.md2moin.core;

public interface Converter {

    String convertToMoin(String input);

    String convertToMoin(String input, int headingOffset);

}
