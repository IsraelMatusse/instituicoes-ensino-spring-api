package com.escolasapiapi.repositores;

import com.escolasapiapi.models.NivelEnsino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelEnsinoRepo extends JpaRepository<NivelEnsino, Long> {
}
