package com.example.primera_evaluacion_ebc.Clases;

import java.io.Serializable;

public class EmpresasNoTecnologicas extends Empresa implements Serializable {
    //los datos de las empresas que tenemos que mostrar son:
    // Logo  (Superclase Empresa)
    // nombre de la Empresa (Superclase Empresa)
    //actividad
    //CNAE

    private String actividad;
    private String cnae;

    public EmpresasNoTecnologicas(int logo, String nombre, String actividad, String cnae) {
        super(logo, nombre);
        this.actividad = actividad;
        this.cnae = cnae;
    }

    public String getActividad() {
        return actividad;
    }

    public String getCnae() {
        return cnae;
    }
}
