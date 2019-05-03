package net.malanius.md2moin.core.emphasis;

public interface EmphasisConverter {

    String convertBold(String input);

    String convertItalics(String input);

    String convertStrikethrough(String input);

}
