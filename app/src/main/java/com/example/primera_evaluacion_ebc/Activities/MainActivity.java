package com.example.primera_evaluacion_ebc.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.primera_evaluacion_ebc.Clases.Empresa;
import com.example.primera_evaluacion_ebc.Clases.EmpresasNoTecnologicas;
import com.example.primera_evaluacion_ebc.Clases.EmpresasTecnologicas;
import com.example.primera_evaluacion_ebc.Clases.ViewHolderEmpresaNoTecnologica;
import com.example.primera_evaluacion_ebc.Clases.ViewHolderEmpresaTecnologica;
import com.example.primera_evaluacion_ebc.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements TextWatcher,AdapterView.OnItemClickListener {

    AutoCompleteTextView autoCompleteTextView;
    ListView listViewEmpresas;
    static ArrayList<Empresa> listaDeEmpresas = new ArrayList<Empresa>();
    static final int EMPRESA_TECNOLOGICA = 1;
    static final int EMPRESA_NO_TECNOLOGICA = 0;


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);


        //limpiamos la lista de empresas y la llenamos con los datos de las empresas
        listaDeEmpresas.clear();
        listaDeEmpresas = Controladora.llenarListaEmpresas();

        listViewEmpresas = findViewById(R.id.listViewEmpresas);
        listViewEmpresas.setAdapter(new AdaptadorParaLaLista(listaDeEmpresas));
        listViewEmpresas.setOnItemClickListener(this);

        intent = new Intent(this, EmpresasTecnologicasActiviy.class);

        autoCompleteTextView.addTextChangedListener(this);
        autoCompleteTextView.setAdapter(new AutoCompleteTexAdapter(this, listaDeEmpresas));}

    //Adapter del autocompleteTex
    class AutoCompleteTexAdapter<T> extends ArrayAdapter<T> {

        private ArrayList<Empresa> empresasAux;

        public AutoCompleteTexAdapter(Context context, ArrayList<Empresa> empresas) {
            super(context, 0);
            empresasAux = new ArrayList<>(empresas);
        }

        public Filter getFilter() {
            return filter;
        }

        Filter filter = new Filter() {

            //Metodo para filtrar la lista de empresas segun los caracteres ingresados
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = null;
                EmpresasTecnologicas empresaTecnologica;
                EmpresasNoTecnologicas empresaNoTecnologica;
                if (charSequence != null) {
                    filterResults = new FilterResults();
                    listaDeEmpresas.clear();
                    for (Empresa empresa : empresasAux) {
                        if (empresa instanceof EmpresasTecnologicas) {
                            empresaTecnologica = (EmpresasTecnologicas) empresa;
                            if (empresaTecnologica.getNombre().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaTecnologica.getLocalizacion().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaTecnologica.getWeb().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaTecnologica.getMail().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                listaDeEmpresas.add(empresa);
                            }
                        } else if (empresa instanceof EmpresasNoTecnologicas) {
                            empresaNoTecnologica = (EmpresasNoTecnologicas) empresa;
                            if (empresaNoTecnologica.getNombre().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaNoTecnologica.getActividad().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaNoTecnologica.getCnae().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                listaDeEmpresas.add(empresa);
                            }
                        }
                    }//Fin for
                    filterResults.values = listaDeEmpresas;
                    filterResults.count = listaDeEmpresas.size();
                }
                return filterResults;
            }

            //Metodo para publicar/Actualizar la lista de empresas.Para que se vean los cambios en el listView se le asigna otra vez un adapter, pero esta vez con la lista de empresas que se hayan filtrado
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults == null) {//Cuando filterResults sea null, sera cuando no se ingrese ningun caracter, entonces se modifica la lista de empresas con todas las empresas
                    listaDeEmpresas = new ArrayList<>(empresasAux);
                }
                //Cuando filterResults no sea  null en performFiltering la listaEmpresas se va incluir como minimo una empresa dentro
                listViewEmpresas.setAdapter(new AdaptadorParaLaLista(listaDeEmpresas));
            }
        };
    }

        //MÉTODO QUE SE EJECUTARÁ CUANDO SE PINCHE EN UNA FILA DE LA LISTA, GRACIAS AL ESCUCHADOR QUE TIENE
// LA LISTA DE EMPRESAS CON EL MÉTODO setOnItemClickListener.
// al pinchar en un elemento de la lista, arrancará otra actividad
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Object objeto = listaDeEmpresas.get(i);
            if (objeto instanceof EmpresasTecnologicas) {

                intent.putExtra("EmpresasTecnologicas", (EmpresasTecnologicas) objeto);
                startActivity(intent);
            }

        }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
        //CLASE DEL ADAPTADOR PARA MONTAR LA LISTA DE LA ACTIVIDAD PRINCIPAL
        private class AdaptadorParaLaLista extends BaseAdapter {
            //Atributo
            private ArrayList<Empresa> listaDeEmpresas = new ArrayList<>();

            //Constructor
            public AdaptadorParaLaLista(ArrayList<Empresa> listaDeEmpresas) {
                this.listaDeEmpresas = listaDeEmpresas;
            }

            //devuleve el tamaño de la lista
            @Override
            public int getCount() {
                return listaDeEmpresas.size();
            }

            // devuelve el contenido (object) de la fila concreta que marca la posición i
            @Override
            public Object getItem(int i) {
                return listaDeEmpresas.get(i);
            }

            //devilvería el id de la fila
            @Override
            public long getItemId(int i) {
                return i;
            }

            //indica el número de layouts distintos que se va a montar con el adaptador de la lista
            @Override
            public int getViewTypeCount() {
                return 2;
            }

            //indica de qué tipo es la fila que se está indicando con la posición
            @Override
            public int getItemViewType(int position) {
                if (getItem(position) instanceof EmpresasNoTecnologicas)
                    return EMPRESA_NO_TECNOLOGICA;
                else
                    return EMPRESA_TECNOLOGICA;
            }

            //se monta cada fila del listado. Se llama por cada registro de la tabla y en función del objeto
// que es, se informa un layout u otro.
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
//se definen cada uno de los elementos del layout
                View viewRow = view;
                ImageView logo;
                TextView nombre;
                TextView web;
                TextView localizacion;
                TextView mail;
                TextView cnae;
//se crea una clase ViewHolder para
                ViewHolderEmpresaTecnologica viewHolderEmpresaTecnologica = null;
                ViewHolderEmpresaNoTecnologica viewHolderEmpresaNoTecnologica = null;

                int tipo = getItemViewType(i);
                if (view == null) {
                    if (tipo == EMPRESA_TECNOLOGICA) {
                        viewRow = getLayoutInflater().inflate(R.layout.empresa_tecnologica, viewGroup, false);
                        logo = viewRow.findViewById(R.id.imageViewLogoTecnologica);
                        nombre = viewRow.findViewById(R.id.textViewNombreTecnologica);
                        web = viewRow.findViewById(R.id.textViewWebTecnologica);
                        localizacion = viewRow.findViewById(R.id.textViewLocalizacionTecnologica);
                        mail = viewRow.findViewById(R.id.textViewEmailTecnologica);
                        viewHolderEmpresaTecnologica = new ViewHolderEmpresaTecnologica(logo, nombre, web, localizacion, mail);
                        viewRow.setTag(viewHolderEmpresaTecnologica);
                    } else {
                        viewRow = getLayoutInflater().inflate(R.layout.empresa_no_tecnologica, viewGroup, false);
                        logo = viewRow.findViewById(R.id.imageViewLogoNoTecnologica);
                        nombre = viewRow.findViewById(R.id.textViewNombreNoTecnologica);
                        cnae = viewRow.findViewById(R.id.textViewActividadNoTecnologica);
                        viewHolderEmpresaNoTecnologica = new ViewHolderEmpresaNoTecnologica(logo, nombre, cnae);
                        viewRow.setTag(viewHolderEmpresaNoTecnologica);
                    }
                } else {
                    if (tipo == EMPRESA_TECNOLOGICA) {
                        viewHolderEmpresaTecnologica = (ViewHolderEmpresaTecnologica) viewRow.getTag();
                    } else {
                        viewHolderEmpresaNoTecnologica = (ViewHolderEmpresaNoTecnologica) viewRow.getTag();
                    }
                }
                if (tipo == EMPRESA_TECNOLOGICA) {
                    EmpresasTecnologicas empresasTecnologicas = (EmpresasTecnologicas) getItem(i);
                    viewHolderEmpresaTecnologica.getImageViewLogo().setImageResource(empresasTecnologicas.getLogo());
                    viewHolderEmpresaTecnologica.getTextViewNombre().setText(empresasTecnologicas.getNombre());
                    viewHolderEmpresaTecnologica.getTextViewWeb().setText(empresasTecnologicas.getWeb());
                    viewHolderEmpresaTecnologica.getTextViewLocalizacion().setText(empresasTecnologicas.getLocalizacion());
                    viewHolderEmpresaTecnologica.getTextViewEmail().setText(empresasTecnologicas.getMail());

                } else {
                    EmpresasNoTecnologicas empresasNoTecnologicas = (EmpresasNoTecnologicas) getItem(i);
                    viewHolderEmpresaNoTecnologica.getImageViewlogo().setImageResource(empresasNoTecnologicas.getLogo());
                    viewHolderEmpresaNoTecnologica.getTextViewnombre().setText(empresasNoTecnologicas.getNombre());
                    viewHolderEmpresaNoTecnologica.getTextViewcnae().setText(empresasNoTecnologicas.getCnae() +
                            "-" + empresasNoTecnologicas.getActividad());
                }
                return viewRow;
            }

        }
    }

