package org.ocs.android.sections;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;

public class OCSVideos implements OCSSectionInterface {
    final private String sectionTag = "VIDEOS";

    private String resolution;
    private String name = "Embedded display";

    public OCSVideos(Context ctx) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        disp.getMetrics(localDisplayMetrics);
        resolution = String.valueOf(localDisplayMetrics.widthPixels) + "*" + String.valueOf(
                localDisplayMetrics.heightPixels);
    }

    public OCSSection getSection() {
        OCSSection s = new OCSSection("VIDEOS");
        s.setAttr("NAME", name);
        s.setAttr("RESOLUTION", resolution);
        s.setTitle(name);
        return s;
    }

    public String toXML() {
        return getSection().toXML();
    }

    public String toString() {
        return getSection().toString();
    }

    public ArrayList<OCSSection> getSections() {
        ArrayList<OCSSection> lst = new ArrayList<>();
        lst.add(getSection());
        return lst;
    }

    public String getSectionTag() {
        return sectionTag;
    }
}
