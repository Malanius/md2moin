package net.malanius.md2moin.core;

final class Constants {

    private Constants(){
        //no instances allowed
    }

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
