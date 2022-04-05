package com.example.primera_evaluacion_ebc.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.primera_evaluacion_ebc.Clases.Empresa;
import com.example.primera_evaluacion_ebc.Clases.Miadaptador;
import com.example.primera_evaluacion_ebc.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    ListView listViewEmpresas;
    ArrayList <Empresa> listaEmpresas= new ArrayList<Empresa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        listViewEmpresas=findViewById(R.id.listViewEmpresas);

        //llenamos las empresas
        listaEmpresas.clear();

       listaEmpresas=Controladora.llenarListaEmpresas();

        Miadaptador miadaptador=new Miadaptador (listaEmpresas, this);
    }
}