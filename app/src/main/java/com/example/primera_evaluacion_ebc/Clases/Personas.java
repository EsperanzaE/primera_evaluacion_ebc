package com.example.primera_evaluacion_ebc.Clases;

import java.io.Serializable;

//clase para guardar las personas de contacto de las empresas
public class Personas implements Serializable {
private String nombre, apellidos, telefono, cargo, email;
    public Personas(String nombre, String apellidos, String telefono, String cargo, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cargo = cargo;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }
}
