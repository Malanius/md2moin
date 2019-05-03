package net.malanius.md2moin.core.codeblocks;

public interface CodeblockConverter {
    String convertCodeBlock(String input);

    String convertInlineCode(String input);
}
