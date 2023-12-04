package Trabalho.controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraController {

	String caminho = "C:\\TEMP\\hol.json"; // caminho definido pelo enunciado

	static int numFaculdades = 1; // contador 

	public void realizarLeitura() throws Exception {
		try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
			StringBuilder jsonConteudo = new StringBuilder();
			String linhas;

			while ((linhas = reader.readLine()) != null) {
				jsonConteudo.append(linhas.trim());  // le o conteudo do arquivo
			}

			String[] linhasJson = jsonConteudo.toString().split("\\},\\s*\\{"); // separa cada parte do json
			for (String linha : linhasJson) { // separa cada parte do arquivo para processar

				processarObjeto(linha); // chama a funcao para achar os campos do enunciado e imprimir
			}
		}
	}
//***************************************************************************************************************************************
	private void processarObjeto(String linha) {

		String nomeUniversidade = extrairValor(linha, "name"); // funcao que acha o campo nome da universidade conforme o enunciado
		String site = extrairValor(linha, "web_pages"); // funcao que acha o campo do website da universidade  conforme o enunciado

		System.out.println(numFaculdades + " " + "Nome da Universidade: " + nomeUniversidade + " || " + " e o site -> " + site); // imprime os valores conforme o enunciado
		numFaculdades++; // contador para deixar claro a quantidade de faculdades que possuem no json
	}

	
	
	
// ****************************************************************************************************************************************
	private String extrairValor(String linha, String campo) {
		int indiceCampo = linha.indexOf("\"" + campo + "\":"); // procura aonde acontece a primeira aparição do nome apresentado
		if (indiceCampo != -1) { // se index of não achar ele fica como -1 ai nesse caso verifica se achou o  campo se sim faz o bloco do if
			int indiceInicioCampo = linha.indexOf("\"", indiceCampo + campo.length() + 3); // procura onde começa a palavra
			int indiceFimCampo = linha.indexOf("\"", indiceInicioCampo + 1); // procura o fim da palavra
			return linha.substring(indiceInicioCampo + 1, indiceFimCampo); // retorna a palavra com base no inicio e no fim
		}
		return null; // se o campo não for encontrado retorna null
	}
}
