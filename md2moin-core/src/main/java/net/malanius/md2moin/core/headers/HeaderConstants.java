package net.malanius.md2moin.core.headers;

final class HeaderConstants {

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

    private HeaderConstants() {
        //no instances allowed
    }
}
