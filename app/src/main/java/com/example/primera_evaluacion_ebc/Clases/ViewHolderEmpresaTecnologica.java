package com.example.primera_evaluacion_ebc.Clases;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderEmpresaTecnologica {
    private ImageView imageViewLogo;
    private TextView textViewNombre, textViewWeb, textViewLocalizacion, textViewEmail;
    public ViewHolderEmpresaTecnologica(ImageView imageViewLogo, TextView textViewNombre,
                                        TextView textViewWeb, TextView textViewLocalizacion,
                                        TextView textViewEmail) {
        this.imageViewLogo=imageViewLogo;
        this.textViewNombre=textViewNombre;
        this.textViewWeb=textViewWeb;
        this.textViewLocalizacion=textViewLocalizacion;
        this.textViewEmail=textViewEmail;
    }

    public ImageView getImageViewLogo() {
        return imageViewLogo;
    }

    public TextView getTextViewNombre() {
        return textViewNombre;
    }

    public TextView getTextViewWeb() {
        return textViewWeb;
    }

    public TextView getTextViewLocalizacion() {
        return textViewLocalizacion;
    }

    public TextView getTextViewEmail() {
        return textViewEmail;
    }
}
