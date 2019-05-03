package net.malanius.md2moin.core.links;

final class LinkConstants {

    static final String LINK_FIND = "\\[(.+?)\\]\\((.+?)\\)";
    static final String LINK_REPLACE = "[[$2|$1]]";

    private LinkConstants() {
        //no instances allowed
    }

}
