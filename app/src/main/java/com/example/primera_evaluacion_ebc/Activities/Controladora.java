package com.example.primera_evaluacion_ebc.Activities;

import com.example.primera_evaluacion_ebc.Clases.Empresa;
import com.example.primera_evaluacion_ebc.Clases.EmpresasNoTecnologicas;
import com.example.primera_evaluacion_ebc.Clases.EmpresasTecnologicas;
import com.example.primera_evaluacion_ebc.Clases.Personas;
import com.example.primera_evaluacion_ebc.R;

import java.util.ArrayList;

public class Controladora {


    public static ArrayList<Empresa> llenarListaEmpresas() {
        ArrayList <Empresa> listaEmpresas=new ArrayList<>();

    //los datos de las empresas que tenemos que mostrar son:
    // Logo y nombre de la Empresa
    // Web de la empresa
    // Localización
    // Mail de Contacto
    // además se mostrarán:
    // La dirección de la empresa
    // Los teléfonos de contacto
    // Un botón que ponga personas de contacto. Vamos a crear un arraylist de personas

    // Montamos la lista de los contactos de las empresas, van a ser los mismos para todas las tecnologicas
        ArrayList<Personas> listaContactos = new ArrayList<Personas>();
        listaContactos.add(new Personas("Juan","Torres","987456123","Becario","tubecariofavorito@gmail.com"));
        listaContactos.add(new Personas("Ana","Lopez","987456123","Limpiador","notengoCorreo@gmail.com"));
        listaContactos.add(new Personas("Carlos","Rodriguez","987456123","Jefe","ensalada@gmail.com"));
        listaContactos.add(new Personas("Juan2","Torres","987456123","Becario","tubecariofavorito@gmail.com"));
        listaContactos.add(new Personas("Ana2","Lopez","987456123","Limpiador","notengoCorreo@gmail.com"));
        listaContactos.add(new Personas("Carlos2","Rodriguez","987456123","Jefe","ensalada@gmail.com"));
//datos de las empresas Tecnologicas: logo, String nombre, String web, String localizacion, String mail, String direccion, String telefonos,
// ArrayList<Personas> contactos
        listaEmpresas.add(new EmpresasTecnologicas(R.drawable.logo_ayesa,"Ayesa","https://www.ayesa.com/es/","37.405670254372204, -6.00576255836253","ayesa@gmail.com","Calle Ayesa Nº12","987451234",listaContactos));
        listaEmpresas.add(new EmpresasTecnologicas(R.drawable.logo_accenture,"Accenture","https://www.accenture.com/es-es","37.40925192610155, -6.0051052","accenture@gmail.com","Calle Accenture Nº10","987451234",listaContactos));
        listaEmpresas.add(new EmpresasTecnologicas(R.drawable.logo_deloitte,"Deloitte","https://www2.deloitte.com/es/es.html","37.39219427031523, -6.010424399999999","deloitte@gmail.com","Direccion Deloitte Nº21","987451234",listaContactos));
        listaEmpresas.add(new EmpresasNoTecnologicas(R.drawable.logo_adidas,"Adidas","Ropa","152"));
        listaEmpresas.add(new EmpresasNoTecnologicas(R.drawable.logo_cruzcampo,"Cruzcampo","Alimentacion","829"));
        listaEmpresas.add(new EmpresasNoTecnologicas(R.drawable.logo_apple,"Apple","Dispositivos moviles","478"));

    return listaEmpresas;
    }
}
