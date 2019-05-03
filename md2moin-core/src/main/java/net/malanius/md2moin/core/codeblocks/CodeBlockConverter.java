package net.malanius.md2moin.core.codeblocks;

public interface CodeBlockConverter {

    String convertCodeBlock(String input);
    String convertInlineCode(String input);

}
