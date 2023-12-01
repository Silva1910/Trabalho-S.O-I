package Trabalho.controller;
/*
 * O TEXTO FOI COMENTADO COM O OBJETIVO DE DEIXAR CLARO OS PASSOS E PARA FACILITAR A ANALISE DO CODIGO DO PROFESSOR 

 * TENDO COMO OBJETIVO A NOTA MAXIMA DO TRABALHO
 * 
 */


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class LeituraController {  

	String caminhoPasta = "C:\\temp\\hol.json"; // Caminho do arquivo JSON Conforme o escopo do professor

	static int i =1;
	public void RealizarLeitura() throws Exception {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(caminhoPasta));
			StringBuilder jsonConteudo = new StringBuilder();
			String linha;

			while ((linha = reader.readLine()) != null) { // Ler o conteúdo do arquivo JSON
				jsonConteudo.append(linha);
			}

			reader.close();

			
			String limparJson = jsonConteudo.toString().replaceAll("\\s", "");  // Remover espaços em branco desnecessários

			
			String[] entradas = limparJson.substring(1, limparJson.length() - 1).split("\\},\\{"); // Analisar manualmente o JSON

			
			for (String entrou : entradas) { // Extrair os valores relevantes do JSON
				
				String[] dados = entrou.split(",");
				String nome = valor(dados, "\"name\""); // procura o nome conforme o escopo
				String site = valor(dados, "\"web_pages\""); // procura o site conforme o escopo
			    nome = formatarNome(nome); // chamada da função para formatar o nome
				System.out.println(i + " o  nome da Universidade e -> " + nome + ", || e o Site dela e -> " + site); // faz a impressão deles conforme o escopo
			i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String valor(String[] dados, String palavra) {
		for (String chave : dados) {
			if (chave.contains(palavra)) {
				String[] parts = chave.split(":");
				if (parts.length > 1) {
				
					StringBuilder valorBuilder = new StringBuilder(parts[1]);
					for (int i = 2; i < parts.length; i++) {  // extrai o valor que esta sendo procurado
						valorBuilder.append(":").append(parts[i]);
					}
					String palavraFinal = valorBuilder.toString().trim();

				
					return palavraFinal.replaceAll("[\"\\[\\]{}]", "").trim(); 	// Remove caracteres especiais e espaços extras
				}
			}
		}
		return ""; // se não encontrou retorna uma string vazia
	}
	  private static String formatarNome(String nome) {
	        StringBuilder nomeFormatado = new StringBuilder();

	        for (int i = 0; i < nome.length(); i++) {
	            char caractere = nome.charAt(i);

	         
	            if (Character.isUpperCase(caractere) && i > 0) {    // Adicionar um espaço antes de cada letra maiúscula, exceto no início do nome
	                nomeFormatado.append(" ");
	            }

	            nomeFormatado.append(caractere);
	        }

	        return nomeFormatado.toString();
	    }

	
}
