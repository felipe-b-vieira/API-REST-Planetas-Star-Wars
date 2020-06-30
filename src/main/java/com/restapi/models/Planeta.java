package com.restapi.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Planeta {
    @Id
    private ObjectId _id;

    private String nome;
    private String clima;
    private String terreno;
    private Integer aparicoes;


    // Constructors
    public Planeta() {}

    public Planeta(ObjectId _id, String nome, String clima, String terreno, Integer aparicoes) {
        this._id = _id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.aparicoes = aparicoes;
    }


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

    public void setAparicoes(Integer aparicoes) {
        this.aparicoes = aparicoes;
    }

}