package com.escolasapiapi.repositores;

import com.escolasapiapi.models.InstituicaoEnsino;
import com.escolasapiapi.models.NivelEnsino;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituicaoEnsinoRepo extends JpaRepository<InstituicaoEnsino, Long> {

    Optional<InstituicaoEnsino>findByCodigo(String codigo);
    Optional<InstituicaoEnsino>findByDesgignacaoIgnoreCase(String designacao);
    Page<InstituicaoEnsino> findByNivelEnsinoId(Long idNivelEnsino, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoDesignacao(String designacao, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoIdAndProvinciaId(Long idNivelEnsino, Long idProvincia, Pageable pageable);
    Page<InstituicaoEnsino> findByNivelEnsinoDesginacaoAndProvinciaDesignacao(String designacaoNivelEnsino, String designacaoProvincia, Pageable pageable);
    Page<InstituicaoEnsino> findByProvinciaId(Long id, Pageable pageable);
    Page<InstituicaoEnsino> findByProvinciaDesignacao(String designacao, Pageable pageable);
}
