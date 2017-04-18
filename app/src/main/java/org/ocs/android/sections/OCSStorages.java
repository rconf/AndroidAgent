package org.ocs.android.sections;

import android.os.Environment;

import java.util.ArrayList;

public class OCSStorages implements OCSSectionInterface {
    final private String sectionTag = "STORAGES";

    private ArrayList<OCSStorage> storages;

    public OCSStorages() {
        storages = new ArrayList<>();

        OCSStorage stExternal = new OCSStorage(Environment.getExternalStorageDirectory(), "External storage");
        OCSStorage stInternal = new OCSStorage(Environment.getDataDirectory(), "Internal storage");
        storages.add(stExternal);
        storages.add(stInternal);
    }

    public String toXML() {
        StringBuilder strOut = new StringBuilder();
        for (OCSStorage o : storages) {
            strOut.append(o.toXml());
        }
        return strOut.toString();
    }

    public String toString() {
        StringBuilder strOut = new StringBuilder();
        for (OCSStorage o : storages) {
            strOut.append(o.toString());
        }
        return strOut.toString();
    }

    public ArrayList<OCSSection> getSections() {
        ArrayList<OCSSection> lst = new ArrayList<>();
        for (OCSStorage o : storages) {
            lst.add(o.getSection());
        }
        return lst;
    }

    public String getSectionTag() {
        return sectionTag;
    }
}