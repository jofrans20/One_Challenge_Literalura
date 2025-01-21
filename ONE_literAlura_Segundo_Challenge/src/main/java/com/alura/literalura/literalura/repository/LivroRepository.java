package com.alura.literalura.literalura.repository;

import com.alura.literalura.literalura.models.Autor;
import com.alura.literalura.literalura.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTitulo(String titulo);
    List<Livro> findByIdioma(String idioma);
}