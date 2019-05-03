package net.malanius.md2moin.core.emphasis;

final class EmphasisConstants {

    private EmphasisConstants(){
        //no instances allowed
    }

    static final String BOLD_FIND = "\\*{2}(.+?)\\*{2}";
    static final String BOLD_REPLACE =  "'''$1'''";

    static final String ITALICS_FIND = "\\*(.+?)\\*";
    static final String ITALICS_REPLACE =  "''$1''";

    static final String STRIKETHROUGH_FIND = "~~(.+?)~~";
    static final String STRIKETHROUGH_REPLACE =  "--($1)--";

}
