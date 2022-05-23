package com.example.primera_evaluacion_ebc.Activities;

import static com.example.primera_evaluacion_ebc.Activities.MainActivity.listaDeEmpresas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primera_evaluacion_ebc.Clases.Empresa;
import com.example.primera_evaluacion_ebc.Clases.EmpresasTecnologicas;
import com.example.primera_evaluacion_ebc.R;
import com.example.primera_evaluacion_ebc.ViewModels.EmpresaTecnologicaActivityVM;

import java.util.Collection;
import java.util.Collections;

public class EmpresasTecnologicasActiviy extends AppCompatActivity implements View.OnClickListener {
    Bundle datos;
    private ImageView imageViewLogo;
    private TextView textViewNombre;
    private EditText editTextViewTelefono;
    private TextView textViewWeb;
    private TextView textViewLocalizacion;
    private TextView textViewEmail;
    private EditText editTextViewDireccion;
    private ImageButton buttonGuardarCambios;
    private Button buttonPersonasContacto;
    private EmpresaTecnologicaActivityVM viewModelEmpresaTecnologica;
    private TextView textViewResultadosGuardados;
    private TextView textViewResultadosDireccion;
    private TextView textViewResultadosTelefono;

    private EmpresasTecnologicas empresasTecnologicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresas_tecnologicas_activiy);

        imageViewLogo = findViewById(R.id.imageLogoActivityEmpresaTecnologica);
        textViewNombre = findViewById(R.id.textNombreActivityEmpresaTecnologica);
        editTextViewTelefono = findViewById(R.id.editTextTelefonoActivityEmpresaTecnologica);

        //TextView Resultados
        textViewResultadosGuardados = findViewById(R.id.textViewResultadosGuardados);
        textViewResultadosDireccion = findViewById(R.id.textViewResultadoDireccion);
        textViewResultadosTelefono = findViewById(R.id.textViewResultadoTelefono);

        //Web
        textViewWeb = findViewById(R.id.textWebActivityEmpresaTecnologica);
        textViewWeb.setOnClickListener(this);

        //Localizacion
        textViewLocalizacion = findViewById(R.id.textLocalizacionActivityEmpresaTecnologica);
        textViewLocalizacion.setOnClickListener(this);

        //Email
        textViewEmail = findViewById(R.id.textViewEmailActivityEmpresaTecnologica);
        textViewEmail.setOnClickListener(this);

        //Direccion
        editTextViewDireccion = findViewById(R.id.editTextViewDireccionActivityEmpresaTecnologica);

        //Botones
        buttonPersonasContacto = findViewById(R.id.buttonPersonasContactoActivityEmpresaTecnologica);
        buttonPersonasContacto.setOnClickListener(this);
        buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios);
        buttonGuardarCambios.setOnClickListener(this);

        //Inicializacion contenido componentes
        //datos = getIntent().getExtras();
        empresasTecnologicas = (EmpresasTecnologicas) getIntent().getSerializableExtra("EmpresasTecnologicas");

        //String nombreEmpresa=datos.getString("EmpresasTecnologicas");
        //int logo=datos.getInt("EmpresasTecnologicas");

//        Collections.sort(listaDeEmpresas);
//        int indice=Collections.binarySearch(listaDeEmpresas,new Empresa(logo,""));
//        EmpresasTecnologicas empresasTecnologicas=(EmpresasTecnologicas) listaDeEmpresas.get(indice);
        String nombre =empresasTecnologicas.getNombre();
        //String nombre =listaDeEmpresas.get(indice).getNombre();
        imageViewLogo.setImageResource(empresasTecnologicas.getLogo());
        //imageViewLogo.setImageResource(logo);
        textViewNombre.setText(empresasTecnologicas.getNombre());
        //textViewNombre.setText(nombre);
        editTextViewTelefono.setText(empresasTecnologicas.getTelefonos());
        //editTextViewTelefono.setText(empresasTecnologicas.getTelefonos());
        textViewWeb.setText(empresasTecnologicas.getWeb());
        //textViewWeb.setText(empresasTecnologicas.getWeb());
        textViewLocalizacion.setText(empresasTecnologicas.getLocalizacion());
        //textViewLocalizacion.setText(empresasTecnologicas.getLocalizacion());
        textViewEmail.setText(empresasTecnologicas.getMail());
        //textViewEmail.setText(empresasTecnologicas.getMail());
        editTextViewDireccion.setText(empresasTecnologicas.getDireccion());
        //editTextViewDireccion.setText(empresasTecnologicas.getDireccion());

        //ViewModel
       viewModelEmpresaTecnologica = new ViewModelProvider(this).get(EmpresaTecnologicaActivityVM.class);
        Toast.makeText(this, viewModelEmpresaTecnologica.getEmpresa().toString(), Toast.LENGTH_SHORT).show();
       viewModelEmpresaTecnologica.getEmpresa().observe(this,this::onTextChanged);
    }

    private void onTextChanged(EmpresasTecnologicas empresasTecnologicas) {
        editTextViewDireccion.setText(empresasTecnologicas.getDireccion());
        editTextViewTelefono.setText(empresasTecnologicas.getTelefonos());

    }
    /*
     * Cabecera: public void onClick(View view)
     * Comentario: Este metodo se encarga de comprobar que elemento al que se le puede hacer click
     *             ha sido clicado y realiza la funcion que corresponda con el botón pulsado.
     * Entradas: View view
     * Salidas: Ninguna
     * Precondiciones: view no puede estar a null, si no se producira una excepcion
     * Postcondicones: Se reazalira la tarea que está asignada al elemento clicable.
     */
    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()){

            case R.id.buttonPersonasContactoActivityEmpresaTecnologica:
                if(empresasTecnologicas.getContactos().size() > 0) {//Si la empresa tiene personas de contacto
                    intent = new Intent(this, PersonasContactoActivity.class);
                    intent.putExtra("ListPersonasContacto", empresasTecnologicas.getContactos());
                }
                break;

            case R.id.textWebActivityEmpresaTecnologica:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(textViewWeb.getText().toString()));
                break;

            case R.id.textLocalizacionActivityEmpresaTecnologica:
                String[] partesLocalizacion = textViewLocalizacion.getText().toString().split(",");//En la localizacion esta tanto la latitud como la altitud y como estan separadas por una coma el metodo split las separa cuando encuentra una coma.
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+partesLocalizacion[0]+","+partesLocalizacion[1]+"(Label)"));
                intent.setPackage("com.google.android.apps.maps");
                break;

            case R.id.textViewEmailActivityEmpresaTecnologica:
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.putExtra(Intent.EXTRA_EMAIL,textViewEmail.getText().toString());
                intentEmail.setType("message/rfc822");

                startActivity(Intent.createChooser(intentEmail,"Envia un mensaje"));
                break;

            case R.id.buttonGuardarCambios:
                empresasTecnologicas.setDireccion(editTextViewDireccion.getText().toString());
                empresasTecnologicas.setTelefonos(editTextViewTelefono.getText().toString());
                viewModelEmpresaTecnologica.getEmpresa().postValue(empresasTecnologicas);
                //Resultados
                textViewResultadosGuardados.setText(R.string.resultados_guardados);
                textViewResultadosDireccion.setText(getString(R.string.direccion)+" " +editTextViewDireccion.getText().toString());
                textViewResultadosTelefono.setText(getString(R.string.telefono)+" " +editTextViewTelefono.getText().toString());
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}