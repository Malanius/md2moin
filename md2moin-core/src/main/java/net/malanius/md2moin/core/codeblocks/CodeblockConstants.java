package net.malanius.md2moin.core.codeblocks;

final class CodeblockConstants {

    private CodeblockConstants(){
        //no instances allowed
    }





    static final String CODE_BLOCK_START_FIND = "^```(.+)$";
    static final String CODE_BLOCK_START_REPLACE = "{{{#!highlight $1";

    static final String CODE_BLOCK_END_FIND = "^```$";
    static final String CODE_BLOCK_END_REPLACE = "}}}";

    static final String INLINE_CODE_FIND = "`(.+?)`";
    static final String INLINE_CODE_REPLACE = "{$1}";

}
