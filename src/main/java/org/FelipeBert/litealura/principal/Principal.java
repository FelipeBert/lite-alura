package org.FelipeBert.litealura.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.FelipeBert.litealura.model.Autor;
import org.FelipeBert.litealura.model.Dados;
import org.FelipeBert.litealura.model.Livro;
import org.FelipeBert.litealura.model.Response;
import org.FelipeBert.litealura.repository.AutorRepository;
import org.FelipeBert.litealura.repository.LivroRepository;
import org.FelipeBert.litealura.service.ConsumoApi;
import org.FelipeBert.litealura.service.ConverteDados;
import org.FelipeBert.litealura.service.IConverteDados;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Principal {
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final IConverteDados conversor = new ConverteDados();
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() throws UnsupportedEncodingException, JsonProcessingException {
        String menu = """
                Escolha o Numero da sua opção
                1 - Buscar Livro Pelo Titulo
                2 - Listar Livros Registrados
                3 - Listar Autores Registrados
                4 - Listar Autores em Determinado Ano
                5 - Listar Livros em Determinado Idioma
                6 - Listar Top 10 Livros mais baixados
                7 - Buscar Autor por Nome
                
                0 - Sair
                """;
        int opcao =  -1;

        do{
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    buscaLivroNaApi();
                    break;
                case 2:
                    System.out.println(livroRepository.findAll());
                    break;
                case 3:
                    System.out.println(autorRepository.findAll());
                    break;
                case 4:
                    listarAutoresPorAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 6:
                    listarTopDezLivros();
                    break;
                case 7:
                    buscarAutorPorNome();
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }while (opcao != 0);
    }

    private void buscarAutorPorNome() {
        System.out.println("Digite o Nome do Autor que deseja Buscar: ");
        String nomeAutor = scanner.nextLine();
        System.out.println(autorRepository.findByNomeContainingIgnoreCase(nomeAutor));
    }

    private void listarTopDezLivros() {
        System.out.println(livroRepository.findTop10ByOrderByNumeroDownloadsDesc());
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Digite o Idioma que deseja buscar: ");
        String formatoIdioma = scanner.nextLine();

        System.out.println(livroRepository.findByIdiomaContainingIgnoreCase(formatoIdioma));
    }

    private void listarAutoresPorAno() {
        System.out.println("Digite o Ano que deseja buscar: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println(autorRepository.buscaAutoresPorAno(ano));
    }

    private void buscaLivroNaApi() throws UnsupportedEncodingException, JsonProcessingException {
        System.out.println("Digite o Nome do Livro que deseja buscar: ");
        String json = consumoApi.obterDados(scanner.nextLine());

        Response responseWrapper = conversor.obterDados(json, Response.class);

        if (responseWrapper.results() != null && !responseWrapper.results().isEmpty()) {
            Dados dados = responseWrapper.results().get(0);

            Autor autor = new Autor(dados.autor().get(0).nome(),
                    dados.autor().get(0).anoNascimento(),
                    dados.autor().get(0).anoMorte());

            Livro livro = new Livro(
                    dados.titulo(),
                    autor,
                    dados.linguas(),
                    dados.downloads()
            );

            autorRepository.save(autor);
            livroRepository.save(livro);
            System.out.println(livro);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }
}