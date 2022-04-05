package com.example.primera_evaluacion_ebc.Clases;

import java.util.ArrayList;

public class EmpresasTecnologicas extends Empresa{
    //los datos de las empresas que tenemos que mostrar son:
    // Logo  (Superclase Empresa)
    // nombre de la Empresa (Superclase Empresa)
    // Web de la empresa
    // Localización
    // Mail de Contacto
    // La dirección de la empresa
    // Los teléfonos de contacto
    // Personas de contacto. (Vamos a crear un arraylist de personas)

    private String web, localizacion, mail, direccion, telefonos;
    ArrayList<Personas> contactos= new ArrayList<>();

    public EmpresasTecnologicas(int logo, String nombre, String web, String localizacion, String mail, String direccion, String telefonos, ArrayList<Personas> contactos) {
        super(logo, nombre);
        this.web = web;
        this.localizacion = localizacion;
        this.mail = mail;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contactos = contactos;
    }

}
