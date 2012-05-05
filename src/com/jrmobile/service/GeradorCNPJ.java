package com.jrmobile.service;

import java.util.Random;

public class GeradorCNPJ {
	static Long generate(Random random) {
		int[] digits = NumberGenerator.generateArray(random, 14, 12);
		digits[12] = 0;
		digits[13] = 0;
		// First digit
		int[] weight = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int total = 0;
		for (int i = 0; i < 12; i++)
			total += digits[i] * weight[i + 1];
		int rest = total % 11;
		if (rest < 2)
			digits[12] = 0;
		else
			digits[12] = 11 - rest;
		// Second digit
		total = 0;
		for (int i = 0; i < 13; i++)
			total += digits[i] * weight[i];
		rest = total % 11;
		if (rest < 2)
			digits[13] = 0;
		else
			digits[13] = 11 - rest;
		return Util.arrayToLong(digits);
	}

	/**
	 * @return 14 digits ##############
	 */
	public static Long generate(long seed) {
		return generate(new Random(seed));
	}

	/**
	 * @return 14 digits ##############
	 */
	public static Long generateRandom() {
		return generate(new Random());
	}
	
	public static Boolean validar( String str_cnpj ) {  
       int soma = 0, dig;  
       String cnpj_calc = str_cnpj.substring(0,12);  
  
       if ( str_cnpj.length() != 14 )  
         return false;  
  
       char[] chr_cnpj = str_cnpj.toCharArray();  
  
       /* Primeira parte */  
       for( int i = 0; i < 4; i++ )  
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )  
           soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;  
       for( int i = 0; i < 8; i++ )  
         if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )  
           soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;  
       dig = 11 - (soma % 11);  
  
       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
                      "0" : Integer.toString(dig);  
  
       /* Segunda parte */  
       soma = 0;  
       for ( int i = 0; i < 5; i++ )  
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )  
           soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;  
       for ( int i = 0; i < 8; i++ )  
         if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )  
           soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;  
       dig = 11 - (soma % 11);  
       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
                      "0" : Integer.toString(dig);  
  
       return str_cnpj.equals(cnpj_calc);  
    }
}
