package org.ocs.android.actions;

import android.util.Log;

import org.ocs.android.agent.OCSDownloadIdParams;
import org.ocs.android.agent.OCSPrologReply;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PrologReplyParser extends DefaultHandler {
    private String currentTag;
    private OCSPrologReply reply = new OCSPrologReply();

    public OCSPrologReply parseDocument(String strReply) {
        Log.d("PrologReplyParser", strReply);
        ByteArrayInputStream bais = new ByteArrayInputStream(strReply.getBytes());

        return parseDocument(bais);
    }

    public OCSPrologReply parseDocument(InputStream is) {
        Log.d("PrologReplyParser", "");
        SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser localSAXParser = localSAXParserFactory.newSAXParser();
            localSAXParser.parse(is, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reply;
    }


    public void startElement(String uri, String local, String qName, Attributes attributes) throws SAXException {
        if ("PARAM".equals(qName)) {
            String id = attributes.getValue("", "ID");
            if (id != null) {
                OCSDownloadIdParams dip = new OCSDownloadIdParams();
                dip.setId(id);
                dip.setSchedule(attributes.getValue("", "SCHEDULE"));
                dip.setCertFile(attributes.getValue("", "CERT_FILE"));
                dip.setType(attributes.getValue("", "TYPE"));
                dip.setInfoLoc(attributes.getValue("", "INFO_LOC"));
                dip.setCertPath(attributes.getValue("", "CERT_PATH"));
                dip.setPackLoc(attributes.getValue("", "PACK_LOC"));
                dip.setForce(attributes.getValue("", "FORCE"));
                dip.setPostcmd(attributes.getValue("", "POSTCMD"));
                reply.getIdList().add(dip);
            } else {
                String frag_lat = attributes.getValue("", "FRAG_LATENCY");
                if (frag_lat != null) {
                    reply.setFragLatency(frag_lat);
                    reply.setPeriodLatency(attributes.getValue("", "PERIOD_LATENCY"));
                    reply.setOn(attributes.getValue("", "ON"));
                    reply.setType(attributes.getValue("", "TYPE"));
                    reply.setCycleLatency(attributes.getValue("", "CYCLE_LATENCY"));
                    reply.setTimeout(attributes.getValue("", "TIMEOUT"));
                    reply.setPeriodeLength(attributes.getValue("", "PERIOD_LENGTH"));
                    reply.setExecutionTimeout(attributes.getValue("", "EXECUTION_TIMEOUT"));
                }
            }
        }
        currentTag = qName;
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) throws SAXException {
        String str = new String(paramArrayOfChar, paramInt1, paramInt2);
        if ("RESPONSE".equals(currentTag)) {
            reply.setResponse(str);
        } else if ("PROLOG_FREQ".equals(currentTag)) {
            reply.setPrologFreq(str);
        } else if ("NAME".equals(currentTag) && reply.getOptName() == null) {
            reply.setOptName(str);
        }
    }
}
