package net.malanius.md2moin.core.links;

public class LinkConstants {

    private LinkConstants() {
    }

    public static final String LINK_FIND = "\\[(.+?)\\]\\((.+?)\\)";
    public static final String LINK_REPLACE = "[[$2|$1]]";

}
