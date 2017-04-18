package org.ocs.android.sections;


public class OCSInput {
    private String type = null;
    private String manufacturer = "NA";
    private String caption = "NA";
    private String description = "NA";
    private String interf = "";
    private String pointtype = "";

/*
    <!ELEMENT INPUTS (TYPE | MANUFACTURER | CAPTION | DESCRIPTION | INTERFACE | POINTTYPE)*>
	INPUTS (TYPE | MANUFACTURER | CAPTION | DESCRIPTION | INTERFACE | POINTTYPE
*/

    public OCSSection getSection() {
        OCSSection s = new OCSSection("INPUTS");
        s.setAttr("TYPE", type);
        s.setAttr("MANUFACTURER", manufacturer);
        s.setAttr("CAPTION", caption);
        s.setAttr("DESCRIPTION", description);
        s.setAttr("INTERFACE", interf);
        s.setAttr("POINTTYPE", pointtype);
        s.setTitle(type);
        return s;
    }

    public String toString() {
        return getSection().toString();
    }

    public String toXml() {
        return getSection().toXML();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterf() {
        return interf;
    }

    public void setInterf(String interf) {
        this.interf = interf;
    }

    public String getPointtype() {
        return pointtype;
    }

    public void setPointtype(String pointtype) {
        this.pointtype = pointtype;
    }
}