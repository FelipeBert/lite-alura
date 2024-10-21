package org.FelipeBert.litealura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(@JsonAlias("title") String titulo,
                    @JsonAlias("download_count") int downloads,
                    @JsonAlias("languages") List<String> linguas,
                    @JsonAlias("authors") List<DadosAutor> autor) {
}
