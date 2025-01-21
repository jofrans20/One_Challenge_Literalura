package com.alura.literalura.literalura.repository;

import com.alura.literalura.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(String nome);
    @Query("SELECT a FROM Autor a\n" +
            "WHERE a.ano_nascimento> :ano_nascimento and a.ano_falecimento < :ano_falecimento")
    List<Autor> findAutorLivingBetweenDates(@Param("ano_nascimento") int ano_nascimento, @Param("ano_falecimento") int ano_falecimento);
}
