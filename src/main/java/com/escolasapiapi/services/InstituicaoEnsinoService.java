package com.escolasapiapi.services;

import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoCriarDTO;
import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoRespostaDTO;
import com.escolasapiapi.exceptions.ContentNotFound;
import com.escolasapiapi.models.InstituicaoEnsino;
import com.escolasapiapi.repositores.InstituicaoEnsinoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstituicaoEnsinoService {

    private final InstituicaoEnsinoRepo instituicaoEnsinoRepo;

    public InstituicaoEnsino criar(InstituicaoEnsino instituicaoEnsino){
        return instituicaoEnsinoRepo.save(instituicaoEnsino);
    }

    public InstituicaoEnsino criarInstituicaoEnsino(InstituicaoEnsinoCriarDTO dto){

    }

    public InstituicaoEnsino buscarPorId(Long id) throws ContentNotFound {
        return instituicaoEnsinoRepo.findById(id).orElseThrow(()->new ContentNotFound("Instituicao de ensino com o id" + id +" nao foi encontrada"));
    }
    public InstituicaoEnsinoRespostaDTO buscarPorIdRes(Long id) throws ContentNotFound {
        InstituicaoEnsino instituicaoEnsino=instituicaoEnsinoRepo.findById(id).orElseThrow(()->new ContentNotFound("Instituicao de ensino com o id" + id +" nao foi encontrada"));;
        return new InstituicaoEnsinoRespostaDTO(instituicaoEnsino);
    }
    public List<InstituicaoEnsinoRespostaDTO> listarInstituicoesDeEnsino(){
        return instituicaoEnsinoRepo.findAll().stream().map(instituicaoEnsino -> new InstituicaoEnsinoRespostaDTO(instituicaoEnsino)).collect(Collectors.toList());
    }
}
