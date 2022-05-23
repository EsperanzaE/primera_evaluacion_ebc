package com.example.primera_evaluacion_ebc.Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpresasTecnologicas extends Empresa implements Serializable {
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

    public EmpresasTecnologicas(int logo, String nombre, String web, String localizacion, String mail,
                                String direccion, String telefonos, ArrayList<Personas> contactos) {
        super(logo, nombre);
        this.web = web;
        this.localizacion = localizacion;
        this.mail = mail;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contactos = contactos;
    }

    public String getWeb() {
        return web;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getMail() {
        return mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public ArrayList<Personas> getContactos() {
        return contactos;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
}
