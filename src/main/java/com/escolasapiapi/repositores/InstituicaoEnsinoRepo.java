package com.escolasapiapi.repositores;

import com.escolasapiapi.models.InstituicaoEnsino;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituicaoEnsinoRepo extends JpaRepository<InstituicaoEnsino, Long> {

    Optional<InstituicaoEnsino>findByCodigo(String codigo);
    Optional<InstituicaoEnsino> findByDesignacaoContainingIgnoreCase(String designacao);
    Page<InstituicaoEnsino> findByNivelEnsinoId(Long idNivelEnsino, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoDesignacaoContainingIgnoreCase(String designacao, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoIdAndProvinciaId(Long idNivelEnsino, Long idProvincia, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoDesignacaoContainigIgnoreCaseAndProvinciaDesignacaoContainingIgnoreCase(String designacaoNivelEnsino, String designacaoProvincia, Pageable pageable);
    Page<InstituicaoEnsino> findByProvinciaId(Long id, Pageable pageable);
    Page<InstituicaoEnsino> findByProvinciaDesignacaoContainingIgnoreCase(String designacao, Pageable pageable);
    Boolean existsByDesignacao(String designacao);
}
