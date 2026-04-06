package SERVICES;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ViaCepService {

   
    public List<String> buscarCep(String cep) {
        List<String> dadosEndereco = new ArrayList<>();
        
        
        cep = cep.replaceAll("\\D", ""); 
        
        if (cep.length() != 8) {
            return null; 
        }

        try {
            
            String urlChamada = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URI(urlChamada).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            
            if (conexao.getResponseCode() != 200) {
                return null; 
            }

           
            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "UTF-8"));
            StringBuilder jsonRetorno = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                jsonRetorno.append(linha);
            }
            leitor.close();

            String jsonFinal = jsonRetorno.toString();

            
            if (jsonFinal.contains("\"erro\": true")) {
                return null;
            }

            
            dadosEndereco.add(extrairValorJson(jsonFinal, "logradouro"));
            dadosEndereco.add(extrairValorJson(jsonFinal, "bairro"));    
            dadosEndereco.add(extrairValorJson(jsonFinal, "localidade")); 
            dadosEndereco.add(extrairValorJson(jsonFinal, "uf"));         

            return dadosEndereco;

        } catch (Exception e) {
            System.out.println("Erro ao consultar a API do ViaCEP: " + e.getMessage());
            return null;
        }
    }

    
    private String extrairValorJson(String json, String chave) {
        String chaveBusca = "\"" + chave + "\":";
        int indexInicial = json.indexOf(chaveBusca);
        if (indexInicial == -1) return "";

        indexInicial += chaveBusca.length();
        int indexFinal = json.indexOf(",", indexInicial);
        if (indexFinal == -1) {
            indexFinal = json.indexOf("}", indexInicial); 
        }

        String valor = json.substring(indexInicial, indexFinal).trim();
        return valor.replaceAll("\"", ""); 
    }
}
