package com.escolasapiapi.services;

import com.escolasapiapi.exceptions.ContentNotFound;
import com.escolasapiapi.models.Provincia;
import com.escolasapiapi.repositores.ProvinciaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProvinciaService {
    private ProvinciaRepo provinciaRepo;

    public Provincia criar(Provincia provincia){
        return provinciaRepo.save(provincia);
    }

    public Provincia buscarPorId(Long id) throws ContentNotFound {
        return provinciaRepo.findById(id).orElseThrow(()->new ContentNotFound("Provincia com o id " + id + " Nao foi encontrada"));
    }
    public List<Provincia> listarProvincias(){
        return provinciaRepo.findAll();
    }


}
