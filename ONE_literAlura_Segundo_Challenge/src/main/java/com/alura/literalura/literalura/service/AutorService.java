package com.alura.literalura.literalura.service;

import com.alura.literalura.literalura.models.Autor;
import com.alura.literalura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (!autores.isEmpty()) {
            autores.forEach(autor -> System.out.println(autor.getNome()));
        } else {
            System.out.println("Nenhum autor encontrado.");
        }
    }

    public void listarAutoresVivos(Scanner scanner) {
        System.out.print("Digite o ano de nascimento do autor: ");
        int anoNascimento = scanner.nextInt();
        System.out.print("Digite o ano de falecimento do autor (0 para vivos): ");
        int anoFalecimento = scanner.nextInt();
        List<Autor> autores = autorRepository.findAutorLivingBetweenDates(anoNascimento, anoFalecimento);

        if (!autores.isEmpty()) {
            autores.forEach(autor -> System.out.println(autor.getNome() + " (" + autor.getAno_nascimento() + "-" + autor.getAno_falecimento() + ")"));
        } else {
            System.out.println("Nenhum autor encontrado.");
        }
    }
}
