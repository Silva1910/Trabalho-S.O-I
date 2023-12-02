package Trabalho.controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraController {

    String caminhoPasta = "C:\\temp\\hol.json";

    static int i = 1;
    public void realizarLeitura() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoPasta))) {
            StringBuilder jsonConteudo = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                jsonConteudo.append(linha.trim());
            }

            // Processar todos os objetos encontrados no conteúdo JSON
            String[] objetosJson = jsonConteudo.toString().split("\\},\\s*\\{");
            for (String objetoJson : objetosJson) {
                // Adicione { e } para formar um objeto JSON completo
                if (!objetoJson.startsWith("{")) {
                    objetoJson = "{" + objetoJson;
                }
                if (!objetoJson.endsWith("}")) {
                    objetoJson = objetoJson + "}";
                }

                processarObjeto(objetoJson);
            }
        }
    }


    private void processarObjeto(String objetoJson) {
        // Selecione os campos desejados
        String nomeUniversidade = extrairValor(objetoJson, "name");
        String webPage = extrairValor(objetoJson, "web_pages");

        // Agora você pode usar 'nomeUniversidade' e 'webPage' conforme necessário
        System.out.println(i +" " + "Nome da Universidade: " + nomeUniversidade + " || " + " e o site -> " + webPage);
    i++;
    }

    // Método auxiliar para extrair valores de campos específicos em um objeto JSON
    private String extrairValor(String json, String campo) {
        int indiceCampo = json.indexOf("\"" + campo + "\":");
        if (indiceCampo != -1) {
            int indiceInicioValor = json.indexOf("\"", indiceCampo + campo.length() + 3);
            int indiceFimValor = json.indexOf("\"", indiceInicioValor + 1);
            return json.substring(indiceInicioValor + 1, indiceFimValor);
        }
        return null;
    }
}
