package com.jrmobile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.jrmobile.service.GeradorCPF;

public class GeradorCPFActivity extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerador_cpf);
	}
	
	/**
	 * Método acionado quando o botão Gerar CPF é pressionado
	 * 
	 * @author jair
	 * @since 10/04/2012
	 * @param view
	 */
	public void gerarCPF(View view) {
		//Recupera o widget do resultado
		EditText txtResultado = (EditText) findViewById(R.id.txtResultado);
		//Recupera o widget do checkbox
		CheckBox checkBoxFormatacao = (CheckBox) findViewById(R.id.checkBoxFormatacao);
		//chama o gerador de CPF
		txtResultado.setText(GeradorCPF.gerarCPF(checkBoxFormatacao.isChecked()));
		//Toast
		Toast.makeText(this, R.string.cpf_gerado, Toast.LENGTH_SHORT).show();
	}

}
