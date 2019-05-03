package net.malanius.md2moin.core;

final class Constants {

    private Constants(){
        //no instances allowed
    }

    static final String H1_FIND = "^# (.*)$";
    static final String H1_REPLACE = "= $1 =";

    static final String H2_FIND = "^## (.*)$";
    static final String H2_REPLACE = "== $1 ==";

    static final String H3_FIND = "^### (.*)$";
    static final String H3_REPLACE = "=== $1 ===";

    static final String H4_FIND = "^#### (.*)$";
    static final String H4_REPLACE = "==== $1 ====";

    static final String H5_FIND = "^##### (.*)$";
    static final String H5_REPLACE = "===== $1 =====";

    static final String UNORDERED_LIST_FIND = "^( *)-";
    static final String UNORDERED_LIST_REPLACE =  " $1*";

    static final String ORDERED_LIST_FIND = "^( *\\d)";
    static final String ORDERED_LIST_REPLACE =  " $1";



    static final String CODE_BLOCK_START_FIND = "^```(.+)$";
    static final String CODE_BLOCK_START_REPLACE = "{{{#!highlight $1";

    static final String CODE_BLOCK_END_FIND = "^```$";
    static final String CODE_BLOCK_END_REPLACE = "}}}";

    static final String INLINE_CODE_FIND = "`(.+?)`";
    static final String INLINE_CODE_REPLACE = "{$1}";

}
