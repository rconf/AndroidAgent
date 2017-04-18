package org.ocs.android.sections;

import java.util.ArrayList;

/**
 * Generic interface for OCS sections (part of inventory)
 */
public interface OCSSectionInterface {
    /**
     * Name of the section
     *
     * @return Name of the section
     */
    String getSectionTag();

    /**
     *
     * @return Section[]
     */
    ArrayList<OCSSection> getSections();

    String toString();

    String toXML();
}
