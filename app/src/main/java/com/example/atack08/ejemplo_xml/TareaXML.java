package com.example.atack08.ejemplo_xml;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by atack08 on 31/1/17.
 */

public class TareaXML extends AsyncTask {

    private MainActivity main;
    private List<Cliente> listaC;

    public TareaXML(MainActivity m){
        this.main = m;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        InputStream in = (InputStream) params[0];
        try {
            System.out.println(in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        listaC = SAXXMLParser.parse(in);
        System.out.println(listaC.size());

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        main.setListaC(listaC);
        main.configurarVistaLista();
    }
}
