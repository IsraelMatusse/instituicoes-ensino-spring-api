package com.escolasapiapi.repositores;

import com.escolasapiapi.models.ZonaRegional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaReginalRepo extends JpaRepository<ZonaRegional, Long> {

    Page<ZonaRegional> findAll(Pageable pageable);
}
