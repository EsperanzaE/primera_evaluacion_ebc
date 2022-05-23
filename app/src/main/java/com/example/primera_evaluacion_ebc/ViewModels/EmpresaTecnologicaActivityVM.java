package com.example.primera_evaluacion_ebc.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.primera_evaluacion_ebc.Clases.EmpresasTecnologicas;


public class EmpresaTecnologicaActivityVM extends ViewModel {

    private MutableLiveData<EmpresasTecnologicas> mldEmpresa;

    public MutableLiveData<EmpresasTecnologicas> getEmpresa(){
        if(mldEmpresa == null){
            mldEmpresa = new MutableLiveData<>();
        }
        return mldEmpresa;
    }
}
