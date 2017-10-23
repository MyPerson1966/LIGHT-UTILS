/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.xmlUtils;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 * MANUAL http://www.quizful.net/post/sax-parser-java
 *
 * @author PSEVO tochka
 */
public class SXParser extends DefaultHandler {

    protected String docUrl;
    protected String thisElement = "";
    private Hashtable tags;

    private DefaultHandler dh = new DefaultHandler();

    @PostConstruct
    public void init() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

//    @Override
//    public void startDocument() throws SAXException {
//        System.out.println("Start parse XML...");
//        tags = new Hashtable();
//    }
//
//    @Override
//    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
//        thisElement = qName + "   " + atts.getLocalName(0) + "=" + atts.getValue(0);
//        String key = localName;
//        Object value = tags.get(key);
//
//        if (value == null) {
//            tags.put(key, new Integer(1));
//        } else {
//            int count = ((Integer) value).intValue();
//            count++;
//            tags.put(key, new Integer(count));
//        }
//    }
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//
//        /*
//        System.out.println("thisElement   " + thisElement + ";      " + new String(ch, start, length));
//
//  if (thisElement.equals("id")) {
//     doc.setId(new Integer(new String(ch, start, length)));
//  }
//  if (thisElement.equals("fam")) {
//     doc.setFam(new String(ch, start, length));
//  }
//  if (thisElement.equals("name")) {
//     doc.setName(new String(ch, start, length));
//  }
//  if (thisElement.equals("otc")) {
//     doc.setOtc(new String(ch, start, length));
//  }
//  if (thisElement.equals("dateb")) {
//     doc.setDateb(new String(ch, start, length));
//  }
//  if (thisElement.equals("datep")) {
//     doc.setDatep(new String(ch, start, length));
//  }
//  if (thisElement.equals("datev")) {
//     doc.setDatev(new String(ch, start, length));
//  }
//  if (thisElement.equals("datebegin")) {
//     doc.setDatebegin(new String(ch, start, length));
//  }
//  if (thisElement.equals("dateend")) {
//     doc.setDateend(new String(ch, start, length));
//  }
//  if (thisElement.equals("vdolid")) {
//     doc.setVdolid(new Integer(new String(ch, start, length)));
//  }
//  if (thisElement.equals("specid")) {
//     doc.setSpecid(new Integer(new String(ch, start, length)));
//  }
//  if (thisElement.equals("klavid")) {
//     doc.setKlavid(new Integer(new String(ch, start, length)));
//  }
//  if (thisElement.equals("stav")) {
//     doc.setStav(new Float(new String(ch, start, length)));
//  }
//  if (thisElement.equals("progid")) {
//     doc.setProgid(new Integer(new String(ch, start, length)));
//  }
//         */
//    }
//
//    @Override
//    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
//        thisElement = "";
//    }
//
//    @Override
//    public void endDocument() {
//        System.out.println("Stop parse XML...");
//    }
}
