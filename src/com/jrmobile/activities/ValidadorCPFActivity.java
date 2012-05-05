package com.jrmobile.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jrmobile.service.GeradorCPF;

/**
 * Activity da tela de Valida��o de CPF
 * 
 * @author jair
 * @since 10/04/2012
 */
public class ValidadorCPFActivity extends ActivityBase {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.validador_cpf);
	}	
	
	/**
	 * Valida o CPF
	 * @param view
	 */
	public void validarCPF(View view) {
		//Recupera os widgets
		EditText txtCPF = (EditText) findViewById(R.id.txtCPF);
		//Chama a camada de serviço
		Boolean resultado = GeradorCPF.validarCPF(txtCPF.getText().toString());
		String message = null;
		if (resultado) {
			message = getResources().getString(R.string.cpf_valido);
		} else {
			message = getResources().getString(R.string.cpf_invalido);
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
