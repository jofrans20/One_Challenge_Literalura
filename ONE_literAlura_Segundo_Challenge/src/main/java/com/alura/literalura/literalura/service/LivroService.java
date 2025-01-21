package com.alura.literalura.literalura.service;

import com.alura.literalura.literalura.models.Livro;
import com.alura.literalura.literalura.models.ResponseWrapper;
import com.alura.literalura.literalura.repository.LivroRepository;
import com.alura.literalura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConverteDados converteDados;

    private static final String API = "https://gutendex.com/books/";

    public void buscarLivrosPeloTitulo(Scanner scanner) {
        System.out.println("Digite o nome do livro: ");
        String pesquisa = (scanner.nextLine()).replace(" ", "+");
        String json = consumoAPI.obterDados(API + "?search=" + pesquisa);
        ResponseWrapper responseWrapper = converteDados.obterDados(json, ResponseWrapper.class);

        if (responseWrapper != null && !responseWrapper.getResults().isEmpty()) {
            List<Livro> pesquisaResultados = responseWrapper.getResults();
            for (Livro livro : pesquisaResultados) {
                // Lógica de associar autor
                if (livro.getAutor() != null) {
                    livro.getAutor().setNome(livro.getAutor().getNome());
                    autorRepository.save(livro.getAutor());
                }
                livroRepository.save(livro);
            }
            System.out.println("Livros encontrados:");
            pesquisaResultados.forEach(livro -> System.out.println(livro.getTitulo()));
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    public void listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        if (!livros.isEmpty()) {
            livros.forEach(livro -> System.out.println(livro.getTitulo()));
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    public void listarLivrosPorIdioma(Scanner scanner) {
        System.out.println("Digite o idioma (ex.: en, pt, ru): ");
        String idiomaPesquisa = scanner.nextLine();
        List<Livro> livros = livroRepository.findByIdioma(idiomaPesquisa);
        if (!livros.isEmpty()) {
            livros.forEach(livro -> System.out.println(livro.getTitulo() + " (" + livro.getIdioma() + ")"));
        } else {
            System.out.println("Nenhum livro encontrado nesse idioma.");
        }
    }
}

