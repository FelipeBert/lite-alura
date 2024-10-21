package org.FelipeBert.litealura.repository;

import org.FelipeBert.litealura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByIdiomaContainingIgnoreCase(String idioma);

    List<Livro> findTop10ByOrderByNumeroDownloadsDesc();
}
