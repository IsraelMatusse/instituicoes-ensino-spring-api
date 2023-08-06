package com.escolasapiapi.services;

import com.escolasapiapi.dtos.nivelEnsinoDTOs.NivelEnsinoRespostaDTO;
import com.escolasapiapi.exceptions.ContentNotFound;
import com.escolasapiapi.models.NivelEnsino;
import com.escolasapiapi.repositores.NivelEnsinoRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NivelEnsinoService {
private final NivelEnsinoRepo nivelEnsinoRepo;

public NivelEnsino criar (NivelEnsino nivelEnsino){
    return nivelEnsinoRepo.save(nivelEnsino);
}

public List<NivelEnsinoRespostaDTO> listarTodosNiveisDeEnsino(){
    return nivelEnsinoRepo.findAll().stream().map(nivelEnsino -> new NivelEnsinoRespostaDTO(nivelEnsino)).collect(Collectors.toList());
}
public NivelEnsino buscarNivelEnsinoPorId(Long id) throws ContentNotFound {
    return nivelEnsinoRepo.findById(id).orElseThrow(()->new ContentNotFound("Nivel de ensino com o Id" + id + " Noa foi encontrado"));
}

}
