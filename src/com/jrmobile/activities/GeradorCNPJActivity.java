package com.jrmobile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.jrmobile.service.GeradorCNPJ;

/**
 * Activity da tela de Geração de CNPJ
 * 
 * @author jair
 * @since 10/04/2012
 */
public class GeradorCNPJActivity extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerador_cnpj);
	}	
	
	/**
	 * Gera o CNPJ
	 * 
	 * @param view
	 */
	public void gerarCNPJ(View view) {
		//Recupera o widget do resultado
		EditText txtResultado = (EditText) findViewById(R.id.txtResultado);
		//Recupera o widget do checkbox
		CheckBox checkBoxFormatacao = (CheckBox) findViewById(R.id.checkBoxFormatacao);
		//chama o gerador de CNPJ
		String cnpj = GeradorCNPJ.generateRandom().toString();
		//Verifica se tem que formatar o checkbox
		if (checkBoxFormatacao.isChecked()) {
			String bloco1 = cnpj.substring(0, 2);  
	        String bloco2 = cnpj.substring(2, 5);  
	        String bloco3 = cnpj.substring(5, 8);  
	        String bloco4 = cnpj.substring(8, 12);
	        String bloco5 = cnpj.substring(12, 14);	        
	        cnpj = String.format("%s.%s.%s/%s-%s", bloco1, bloco2, bloco3, bloco4, bloco5);
		}
		txtResultado.setText(cnpj);
		//Toast
		Toast.makeText(this, R.string.cnpj_gerado, Toast.LENGTH_SHORT).show();
		
	}
	
}
