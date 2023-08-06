package com.escolasapiapi.repositores;

import com.escolasapiapi.models.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinciaRepo extends JpaRepository<Provincia, Long> {

    Optional<Provincia> findByDesignacao(String designacao);
}
