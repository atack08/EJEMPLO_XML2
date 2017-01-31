package com.example.atack08.ejemplo_xml;

/**
 * Created by atack08 on 31/1/17.
 */

public class Cliente {

    private String nif, nombre;

    public Cliente(){};

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
