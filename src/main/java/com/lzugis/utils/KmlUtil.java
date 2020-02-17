package com.lzugis.utils;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class KmlUtil {
    private static DocumentBuilderFactory dbFactory = null;
    private static DocumentBuilder db = null;
    private static Document document = null;

    public static void main(String[] args) {
        String url = "D:\\code\\spring-boot-demo\\file\\placemarker.kml";
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            db = dbFactory.newDocumentBuilder();
            document = db.parse(url);
            NodeList docNode = document.getElementsByTagName("Document");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(url);
    }
}
