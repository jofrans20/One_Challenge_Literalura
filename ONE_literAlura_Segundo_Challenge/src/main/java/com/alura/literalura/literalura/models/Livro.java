package com.alura.literalura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "livros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {
    @Id
    private Long id;
    private String titulo;

    @ManyToOne
    private Autor autor; // Um livro pode ter um autor

    private String idioma;
    private int numero_downloads;

    @JsonCreator
    public Livro(@JsonProperty("id") Long id, @JsonProperty("title") String titulo, @JsonProperty("authors") List<Autor> autor, @JsonProperty("languages") List<String> idioma, @JsonProperty("download_count") int numero_downloads) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor.isEmpty() ? null : autor.get(0);
        this.idioma = idioma.isEmpty() ? "null" : idioma.get(0);
        this.numero_downloads = numero_downloads;
    }

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumero_downloads() {
        return numero_downloads;
    }

    public void setNumero_downloads(int numero_downloads) {
        this.numero_downloads = numero_downloads;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo='" + titulo + '\'' + ", idioma=" + idioma + ", numero_downloads=" + numero_downloads + ", autor=" + autor + '}';
    }
}
