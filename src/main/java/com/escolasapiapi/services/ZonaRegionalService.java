package com.escolasapiapi.services;

import com.escolasapiapi.exceptions.ContentNotFound;
import com.escolasapiapi.models.ZonaRegional;
import com.escolasapiapi.repositores.ZonaReginalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZonaRegionalService {

    private final ZonaReginalRepo zonaReginalRepo;

    public ZonaRegional criar(ZonaRegional zonaRegional){
        return zonaReginalRepo.save(zonaRegional);
    }
    public ZonaRegional buscarPorId(Long id) throws ContentNotFound {
        return zonaReginalRepo.findById(id).orElseThrow(()->new ContentNotFound("Zona regional nao encontrada"));
    }

    public Page<ZonaRegional> listarZonasRegionais(int size, int page, Sort sort){
        Pageable pageable= PageRequest.of(page, size, sort);
        return zonaReginalRepo.findAll(pageable);

    }

}
