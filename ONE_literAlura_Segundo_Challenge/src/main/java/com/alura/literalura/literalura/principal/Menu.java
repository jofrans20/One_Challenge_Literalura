package com.alura.literalura.literalura.principal;

import com.alura.literalura.literalura.service.AutorService;
import com.alura.literalura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Buscar livros pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("0 - Sair");
            System.out.print("Número de sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    livroService.buscarLivrosPeloTitulo(scanner);
                    break;
                case 2:
                    livroService.listarLivros();
                    break;
                case 3:
                    autorService.listarAutores();
                    break;
                case 4:
                    autorService.listarAutoresVivos(scanner);
                    break;
                case 5:
                    livroService.listarLivrosPorIdioma(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

