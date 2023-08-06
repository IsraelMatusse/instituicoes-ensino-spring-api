package com.escolasapiapi.repositores;

import com.escolasapiapi.models.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepo extends JpaRepository<Provincia, Long> {

}
