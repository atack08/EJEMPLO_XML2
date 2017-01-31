package com.example.atack08.ejemplo_xml;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by atack08 on 31/1/17.
 */

public class SAXXMLParser {


    public static List<Cliente> parse(InputStream is) {
        List<Cliente> employees = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // create a SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            employees = saxHandler.getClientes();

        } catch (Exception ex) {
            Log.d("XML", "SAXXMLParser: parse() failed");
        }

        // return Employee list
        return employees;
    }
}
