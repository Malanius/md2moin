package net.malanius.md2moin.core.lists;

public interface ListConverter {
    String convertUnorderedList(String input);

    String convertOrderedList(String input);
}
