package com.example.atack08.ejemplo_xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atack08 on 31/1/17.
 */

public class SAXXMLHandler extends DefaultHandler {

    private List<Cliente> listaC;
    private String tempVal;
    private Cliente clienteTemp;

    public SAXXMLHandler() {
        listaC = new ArrayList<Cliente>();
    }

    public List<Cliente> getClientes() {
        return listaC;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        tempVal = "";
        if(qName.equalsIgnoreCase("cliente")){
            clienteTemp = new Cliente();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        tempVal = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if(qName.equalsIgnoreCase("cliente")){

            listaC.add(clienteTemp);
        }
        else if(qName.equalsIgnoreCase("nombre")){
            clienteTemp.setNombre(tempVal);
        }
        else if (qName.equalsIgnoreCase("nif")){
            clienteTemp.setNif(tempVal);
        }
    }
}
