package org.ocs.android.actions;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PrefsParser extends DefaultHandler {
    private String keyName;
    private String keyValue;
    private Editor edit;

    public void parseDocument(File paramFile, SharedPreferences prefs) {
        Log.d("PARSE", "Start parseDocument ");
        edit = prefs.edit();

        SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser localSAXParser = localSAXParserFactory.newSAXParser();
            localSAXParser.parse(paramFile, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) throws SAXException {
        String str = new String(paramArrayOfChar, paramInt1, paramInt2);
        keyValue = str;
        Log.d("PARSE", "characters" + str);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        Log.d("PARSE", "endElement");
        Log.d("PARSE", "uri   : " + uri);
        Log.d("PARSE", "lName : " + localName);
        Log.d("PARSE", "qName : " + qName);
        if ("map".equals(qName)) {
            edit.apply();
        } else if ("string".equals(qName) && !"k_deviceUid".equals(keyName)) {
            Log.d("PARSE", keyName + "/" + keyValue);
            edit.putString(keyName, keyValue);
        }
    }

    public void startElement(String uri, String local, String qName, Attributes attributes) throws SAXException {
        keyName = attributes.getValue("", "name");
        keyValue = attributes.getValue("", "value");
        Log.d("PARSE", "startElement");
        Log.d("PARSE", "uri     : " + uri);
        Log.d("PARSE", "local   : " + local);
        Log.d("PARSE", "qName : " + qName);
        if (qName.equalsIgnoreCase("boolean")) {
            Log.d("PARSE", keyName + "/" + keyValue);
            edit.putBoolean(keyName, "true".equals(keyValue));
        }
    }
}
