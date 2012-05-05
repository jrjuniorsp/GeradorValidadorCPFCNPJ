package com.jrmobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GeradorValidadorCPFCNPJActivity extends ActivityBase {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    /**
     * Chama a activity de Gerar CPF
     * @param view
     */
    public void geradorCPF(View view) {
    	Intent intent = new Intent(this, GeradorCPFActivity.class);
    	startActivity(intent);
    }
    
    /**
     * Chama a tela de Validar CPF
     * @param view
     */
    public void validadorCPF(View view) {
    	Intent intent = new Intent(this, ValidadorCPFActivity.class);
    	startActivity(intent);
    }
    
    /**
     * Chama a activity de Gerar CNPJ
     * @param view
     */
    public void geradorCNPJ(View view) {
    	Intent intent = new Intent(this, GeradorCNPJActivity.class);
    	startActivity(intent);    	
    }
    
    /**
     * Chama a activity de Validar CNPJ
     * @param view
     */
    public void validadorCNPJ(View view) {
    	Intent intent = new Intent(this, ValidadorCNPJActivity.class);
    	startActivity(intent);
    }

	
	
}