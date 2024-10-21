package org.FelipeBert.litealura.repository;

import org.FelipeBert.litealura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE :ano BETWEEN a.anoNascimento AND COALESCE(a.anoMorte, :ano)")
    List<Autor> buscaAutoresPorAno(Integer ano);

    Optional<Autor> findByNomeContainingIgnoreCase(String nome);
}