package net.malanius.md2moin.core.lists;

final class ListConstants {

    static final String UNORDERED_LIST_FIND = "^( *)-";
    static final String UNORDERED_LIST_REPLACE = " $1*";
    static final String ORDERED_LIST_FIND = "^( *\\d)";
    static final String ORDERED_LIST_REPLACE = " $1";

    private ListConstants() {
        //no instances allowed
    }

}
