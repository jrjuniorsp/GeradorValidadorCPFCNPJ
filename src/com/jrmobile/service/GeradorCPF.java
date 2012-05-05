package com.jrmobile.service;





/**
 * Classe de gera��o e validac�o de CPF
 * 
 * @author jair
 * @since 10/04/2012
 */
public class GeradorCPF {
	
	/**
	 * Construtor private para manter o singleton
	 */
	private GeradorCPF() {
		//Do nothing
	}

	/**
	 * M�todo que gera um novo CPF de forma randomica
	 * 
	 * @author jair
	 * @since 10/04/2012
	 * 
	 * @param Boolean - true formata o valor, false n�o formata
	 * @return
	 */
	public static String gerarCPF(Boolean formatacao) {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		String cpf = iniciais + calcDigVerif(iniciais);
		//Se for true, formata o valor
		if (formatacao) {
			cpf = formatarCPF(cpf);			
		}
		return cpf;
	}

	/**
	 * Dado um CPF, o m�todo valida se � v�lido ou n�o
	 * 
	 * @author jair
	 * @since 10/04/2012
	 * @param cpf - String
	 * @return - true or false
	 */
	public static Boolean validarCPF(String cpf) {
		if (cpf.length() != 11)
			return false;
		String numDig = cpf.substring(0, 9);
		return calcDigVerif(numDig).equals(cpf.substring(9, 11));
	}
	
	public static String formatarCPF(String cpf) {
		String bloco1 = cpf.substring(0, 3);  
        String bloco2 = cpf.substring(3, 6);  
        String bloco3 = cpf.substring(6, 9);  
        String bloco4 = cpf.substring(9, 11);
        
        return  String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4);
	}

	private static String calcDigVerif(String num) {

		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));

		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));

		return primDig.toString() + segDig.toString();
	}
}
