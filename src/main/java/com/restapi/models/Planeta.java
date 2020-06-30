package com.restapi.models;

//Import para o Spring e MongoDB
import com.fasterxml.jackson.core.JsonParser;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

//Import para as requisições da API
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.net.ssl.HttpsURLConnection;

public class Planeta {
    //essa informação precisa para o MongoDB
    @Id
    private ObjectId _id;


    //Informações dos planetas
    private String nome;
    private String clima;
    private String terreno;
    //Essa é pega com request de outra API
    private Integer aparicoes;


    // Constructors
    public Planeta() {}

    public Planeta(ObjectId _id, String nome, String clima, String terreno) {
        this._id = _id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }

    //Função responsável por achar a quantidade de aparicoes do planeta nos filmes de Star Wars
    //Retorna -1 se não encontrar o planeta na API
    //Ele faz a requisição na API, gera o Json da resposta e retorna a quantidade de aparições como Integer
    private Integer geraQuantidadeAparicoes(String nome){

        //Objeto JSON que vai salvar as informações pedidas.
        JSONObject root;
        //O endereço de pesquisa a ser usado
        String urlAPI = "https://swapi.dev/api/planets/?page=1";
        //Declaração das variáveis usadas dentro do loop
        URL url;
        HttpURLConnection conn;
        Integer responsecode,quantFilmes;
        JSONTokener tokener;
        JSONArray planetas,filmesPlanetaAtual;


        //While usado para verificar todas as páginas de planetas, se for null, significa que não tem mais páginas
        while (!urlAPI.equals("null")) {
            try {
                //Configuração da conexão e pede as informações dos Planetas
                url = new URL(urlAPI);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.connect();

                //pega o código de resposta e verifica se está tudo certo
                responsecode = conn.getResponseCode();
                if (responsecode != 200)
                    throw new RuntimeException("HttpResponseCode: " + responsecode);
                else {

                    //Gera um output do Request feito para ser transformado em JSON
                    StringBuilder sb = new StringBuilder();
                    String line;
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }

                    //Converte o output em JSON
                    root = new JSONObject(sb.toString());

                    //pega o endereço da próxima página que vai ser usado para verificar os próximos planetas
                    //a API só aceit https mas envia como http, precisa ajustar isso
                    urlAPI = root.get("next").toString().replace("http","https");

                    //aqui vamos iterar por cada planeta e verificar se o nome é igual ao que já temos
                    planetas = root.getJSONArray("results");
                    for (int i = 0; i < planetas.length(); i++) {
                        JSONObject planetaAtual = planetas.getJSONObject(i);

                        //se eu encontrar o planeta, então retorno a quantidade de aparições
                        if (planetaAtual.get("name").toString().equals(nome)) {
                            filmesPlanetaAtual = planetaAtual.getJSONArray("films");
                            quantFilmes = filmesPlanetaAtual.length();
                            conn.disconnect();
                            return quantFilmes;
                        }
                    }

                }
                //Fecha conexão
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                //return -1;
            }
        }
        //retornar -1 significa que não achou a informação do planeta na API
        return -1;
    }

    //Getters and Setters
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Integer getAparicoes() {
        return aparicoes;
    }

    public void setAparicoes(String nomePlaneta) {
        this.aparicoes = geraQuantidadeAparicoes(nomePlaneta);
    }

}