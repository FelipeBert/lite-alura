package org.FelipeBert.litealura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String idioma;

    private Integer numeroDownloads;

    @ManyToOne
    private Autor autor;

    public Livro() {}

    public Livro(String titulo, Autor autor, List<String> lingua, Integer numeroDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = (String.valueOf(lingua.get(0))) ;
        this.numeroDownloads = numeroDownloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return "\nTitulo:'" + titulo + '\'' +
                "\nAutor: " + autor.getNome() + '\'' +
                "\nIdioma: " + idioma +
                "\nNumero de Downloads: " + numeroDownloads;
    }
}
