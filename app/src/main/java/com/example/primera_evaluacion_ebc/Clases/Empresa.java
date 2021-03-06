package com.example.primera_evaluacion_ebc.Clases;

import java.io.Serializable;

public class Empresa implements Comparable<Empresa>, Serializable {
    // las informacion de la superclase Empresa será
    // Logo
    // nombre de la Empresa

    private  int logo;
    private String nombre;

    public Empresa(int logo,
                   String nombre) {
        this.logo = logo;
        this.nombre = nombre;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public int compareTo(Empresa empresa) {

          return this.logo - empresa.logo;


    }
}
