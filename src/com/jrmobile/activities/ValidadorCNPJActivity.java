package com.jrmobile.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jrmobile.service.GeradorCNPJ;

/**
 * Activity da tela de Validador de CNPJ
 * 
 * @author jairrillo
 * @since 20/04/2012
 *
 */
public class ValidadorCNPJActivity extends ActivityBase {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validador_cnpj);
    }
    
    /**
     * Método acionado quando o botão validar é pressionado na tela
     * @param view
     */
    public void validarCNPJ(View view) {
		//Recupera os widgets
		EditText txtCNPJ = (EditText) findViewById(R.id.txtDigitarCNPJ);
		//Chama a camada de serviço
		Boolean resultado = true;
		try {
			resultado = GeradorCNPJ.validar(txtCNPJ.getText().toString());
		} catch (Exception e) {
			resultado = false;
		}
		String message = null;
		if (resultado) {
			message = getResources().getString(R.string.cnpj_valido);
		} else {
			message = getResources().getString(R.string.cnpj_invalido);
		}
		//Abre o Dialog
		AlertDialog dialog = new AlertDialog.Builder(this).create();
		dialog.setMessage(message);
		dialog.setButton("OK", new DialogInterface.OnClickListener() {				
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});			
		dialog.show();		

    }

}
