package com.example.atack08.ejemplo_xml;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Cliente> listaC;
    private AdaptadorClientes adaptador;
    private ListView vistaListaClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vistaListaClientes = (ListView)findViewById(R.id.listaClientes);
    }

    public void leerFicheroXML(View v){

        try {

            TareaXML tarea =  new TareaXML(this);
            tarea.execute(getAssets().open("efecto2000.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void configurarVistaLista(){
        adaptador = new AdaptadorClientes(this,listaC);
        vistaListaClientes.setAdapter(adaptador);
    }

   // -------------- CLASE INTERNA PARA EL ADAPTADOR DE LA LISTA

    class AdaptadorClientes extends ArrayAdapter<Cliente>{

        public AdaptadorClientes(Context context, List<Cliente> listaC) {
            super(context, R.layout.listitem_cliente, listaC);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_cliente, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.labelNombre);
            lblNombre.setText(listaC.get(position).getNombre());

            TextView lblNif = (TextView)item.findViewById(R.id.labelNif);
            lblNif.setText(listaC.get(position).getNif());

            return item;

        }
    }

    public void setListaC(List<Cliente> listaC) {
        this.listaC = listaC;
    }
}
