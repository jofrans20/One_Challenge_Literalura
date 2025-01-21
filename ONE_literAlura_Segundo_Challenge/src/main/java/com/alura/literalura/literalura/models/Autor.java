package com.alura.literalura.literalura.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int ano_nascimento;
    private int ano_falecimento;

    @JsonCreator
    public Autor(
            @JsonProperty("name") String nome,
            @JsonProperty("birth_year") int ano_nascimento,
            @JsonProperty("death_year") int ano_falecimento) {
        this.nome = (nome == null) ? "" : nome;
        this.ano_nascimento = ano_nascimento;
        this.ano_falecimento = ano_falecimento;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public int getAno_falecimento() {
        return ano_falecimento;
    }

    public void setAno_falecimento(int ano_falecimento) {
        this.ano_falecimento = ano_falecimento;
    }

}
