package Trabalho.view;

/* Enunciado



 * Pegar o conteúdo do site: http://universities.hipolabs.com/search?country=United+Kingdom 
 * (Usar modo RAW ou Dados Brutos), esse site traz um arquivo comuniversidades britânicas. 
 * Grave em um arquivo chamado hol.json na pasta C:\TEMP (\tmp se for Linux) e faça uma aplicação java que, na classe principal, 
 * chame uma classe de controle que leia o arquivo, e, apresenta o nome da faculdade e seu site, para todas as faculdades específicas.

*/

import Trabalho.controller.LeituraController;

public class Principal {
	 public static void main(String[] args) throws Exception {
		    
	        LeituraController leituraController = new LeituraController();

	        leituraController.realizarLeitura();     // Chamar o método realizarLeitura()
	    }
}
