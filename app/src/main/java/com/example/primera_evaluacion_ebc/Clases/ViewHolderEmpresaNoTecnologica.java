package com.example.primera_evaluacion_ebc.Clases;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderEmpresaNoTecnologica {
    ImageView imageViewlogo;
    TextView textViewnombre;
    TextView textViewcnae;

    public ViewHolderEmpresaNoTecnologica(ImageView imageViewlogo, TextView textViewnombre, TextView textViewcnae) {
        this.imageViewlogo=imageViewlogo;
        this.textViewnombre=textViewnombre;
        this.textViewcnae=textViewcnae;
    }

    public ImageView getImageViewlogo() {
        return imageViewlogo;
    }

    public TextView getTextViewnombre() {
        return textViewnombre;
    }

    public TextView getTextViewcnae() {
        return textViewcnae;
    }
}
