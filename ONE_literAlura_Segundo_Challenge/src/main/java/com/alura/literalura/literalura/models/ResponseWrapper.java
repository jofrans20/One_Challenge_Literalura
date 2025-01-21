package com.alura.literalura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper {
    private List<Livro> results;

    public List<Livro> getResults() {
        return results;
    }

    public Livro getResult() {
        return results.get(0);
    }

    // Construtor padrão
    public ResponseWrapper() {
    }
}
