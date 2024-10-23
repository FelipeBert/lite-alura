# LiteAlura - Biblioteca de Livros

Este projeto é uma aplicação em Java que permite buscar, registrar e listar livros e autores. A aplicação consome dados de uma API externa (Gutendex) e armazena informações sobre livros e autores em um banco de dados relacional utilizando JPA e Hibernate.

## Funcionalidades

- Buscar livros por título a partir da API externa Gutendex.
- Listar livros registrados no banco de dados.
- Listar autores registrados no banco de dados.
- Listar autores por ano de nascimento ou morte.
- Listar livros por idioma.
- Listar os 10 livros mais baixados.
- Buscar autores por nome.

## Tecnologias Utilizadas

- **Java 17**: Linguagem principal.
- **Spring Boot**: Framework para simplificação de criação de aplicações Java.
- **Jakarta Persistence API (JPA)**: Mapeamento objeto-relacional (ORM).
- **Hibernate**: Implementação do JPA.
- **PostgreSQL**: Banco de dados relacional.
- **Gutendex API**: API pública utilizada para buscar dados sobre livros.
- **Jackson**: Biblioteca para serialização/deserialização de JSON.
- **Maven**: Gerenciador de dependências.

## Estrutura do Projeto

- `model`: Contém as classes que representam os modelos da aplicação (`Autor`, `Livro`, etc.).
- `repository`: Interfaces para persistência de dados com JPA.
- `service`: Classes de serviço para consumo de API e conversão de dados.
- `principal`: Ponto de entrada da aplicação, contendo o menu e lógica de interação com o usuário.

## Instalação e Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/FelipeBert/lite-alura.git
   ```

2. Navegue até o diretório do projeto:
    ```bash
   cd litealura
   ```

3. Configure as dependências do Maven:
    ```bash
   mvn clean install
   ```

4. Configure o banco de dados PostgreSQL e as variáveis de ambiente necessárias para a conexão.

5. Execute o projeto:
    ```bash
    mvn spring-boot:run
    ```

## Utilização

Ao iniciar a aplicação, o menu principal será exibido. A partir dele, você pode escolher várias opções, como buscar livros na API, listar autores e livros registrados, e mais. Abaixo estão as opções disponíveis:

1. Buscar Livro Pelo Título
2. Listar Livros Registrados
3. Listar Autores Registrados
4. Listar Autores em Determinado Ano
5. Listar Livros em Determinado Idioma
6. Listar Top 10 Livros Mais Baixados
7. Buscar Autor por Nome
0. Sair

## Exemplo de Uso

***Buscar Livro na API***

1. Selecione a opção 1 no menu.
2. Insira o título do livro que deseja buscar.
3. Se o livro for encontrado, ele será registrado no banco de dados e exibido.

***Listar Livros***

Selecione a opção 2 no menu para listar todos os livros registrados no banco de dados.

***Listar Autores***

Selecione a opção 3 no menu para listar todos os autores registrados.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou quiser sugerir melhorias, fique à vontade para abrir uma issue ou enviar um pull request.