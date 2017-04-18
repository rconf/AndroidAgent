package org.ocs.android.actions;

public class OCSProtocolException extends Exception {
    private static final long serialVersionUID = 8115364599391499226L;

    public OCSProtocolException(String s) {
        super(s);
        OCSLog ocslog = OCSLog.getInstance();
        ocslog.error(s);
    }
}
