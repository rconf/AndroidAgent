package org.ocs.android.sections;


public class OCSSoftware {
    private String comments;
    private String filesize;
    private String folder;
    private String installDate;
    private String name;
    private String publisher;
    private String version;

    public OCSSection getSection() {
        OCSSection s = new OCSSection("SOFTWARES");
        s.setAttr("PUBLISHER", publisher);
        s.setAttr("NAME", name);
        s.setAttr("VERSION", version);
        s.setAttr("FOLDER", folder);
        s.setAttr("FILESIZE", filesize);
        s.setAttr("COMMENTS", "");
        s.setAttr("INSTALLDATE", "");
        s.setTitle(name);
        return s;
    }

    public String toXml() {
        return getSection().toXML();
    }

    public String toString() {
        return getSection().toString();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}