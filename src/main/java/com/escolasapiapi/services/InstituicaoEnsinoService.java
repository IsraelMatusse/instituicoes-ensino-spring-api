package com.escolasapiapi.services;

import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoCriarDTO;
import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoRespostaDTO;
import com.escolasapiapi.exceptions.ContentAlreadyExists;
import com.escolasapiapi.exceptions.ContentNotFound;
import com.escolasapiapi.models.InstituicaoEnsino;
import com.escolasapiapi.models.NivelEnsino;
import com.escolasapiapi.models.Provincia;
import com.escolasapiapi.repositores.InstituicaoEnsinoRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InstituicaoEnsinoService {

    private final InstituicaoEnsinoRepo instituicaoEnsinoRepo;
    private final ProvinciaService provinciaService;
    private final NivelEnsinoService nivelEnsinoService;

    public InstituicaoEnsino criar(InstituicaoEnsino instituicaoEnsino){
        return instituicaoEnsinoRepo.save(instituicaoEnsino);
    }
    public InstituicaoEnsino crirarNivelEnsino(InstituicaoEnsinoCriarDTO dto) throws ContentAlreadyExists, ContentNotFound {
        Boolean instExist = existePorDesignacao(dto.designacao());
        if(instExist){
            throw new ContentAlreadyExists("A instituicao com o designacao" + dto.designacao() + " Ja existe");
        }
        Provincia provincia= provinciaService.buscarPorId(dto.provincia());
        NivelEnsino nivelEnsino=nivelEnsinoService.buscarNivelEnsinoPorId(dto.nivelEnsino());
        InstituicaoEnsino novaInstituicaoEnsino;
        try {
            novaInstituicaoEnsino = new InstituicaoEnsino(dto, provincia, nivelEnsino);
        }catch (HibernateException | NoSuchAlgorithmException e){
            throw new HibernateException("Erro ao criar uma instituicao");
        }
        return novaInstituicaoEnsino;

    }
    public Boolean existePorDesignacao(String designacao){
        return instituicaoEnsinoRepo.existsByDesignacao(designacao);
    }


    public InstituicaoEnsinoRespostaDTO buscarInstituicaoDeEnsinoPeloId(Long id ) throws ContentNotFound {

        Objects.requireNonNull(id, "O Id da instituicao nao pode ser nulo");
        if (instituicaoEnsinoRepo.existsById(id)){
            throw new ContentNotFound("Instituicao com o id" +id + "nao foi encontrada");
        }
        InstituicaoEnsino instituicaoEnsino=instituicaoEnsinoRepo.findOneById(id);
        return new InstituicaoEnsinoRespostaDTO(instituicaoEnsino);
    }
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesEnsinoPag(int size, int page, Sort sort){
        Pageable pageable= PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos= instituicaoEnsinoRepo.findAll(pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);
    }
    //buscar instituicao de ensino pelo designacao
    public InstituicaoEnsinoRespostaDTO buscarInstituicaoEnsinoPelaDesignacao(String designacao) throws ContentNotFound {
        InstituicaoEnsino instituicaoEnsino= instituicaoEnsinoRepo.findByDesignacaoContainingIgnoreCase(designacao).orElseThrow(()->new ContentNotFound("Instituicao de ensino com a designacao" + designacao + "Nao foi encontrada" ));
        return new InstituicaoEnsinoRespostaDTO(instituicaoEnsino);
    }
    //buscar instituicao de ensino por codigo
    public InstituicaoEnsinoRespostaDTO buscarInstituicaoEnsinoPeloCodigo(String codigo) throws ContentNotFound {

        Objects.requireNonNull(codigo, "O codigo da instituicao nao pode ser nulo");
        if(!instituicaoEnsinoRepo.existsByCodigo(codigo)){
            throw new ContentNotFound("Instituicao nao encontrada");
        }
       InstituicaoEnsino instituicaoEnsino= instituicaoEnsinoRepo.findByCodigo(codigo);
        return new InstituicaoEnsinoRespostaDTO(instituicaoEnsino);
    }
    //buscar instituicao de ensino pelo id do nivel
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesDeEnsinoPeloIdDoNivel(Long id, Sort sort, int size, int page){
        Pageable pageable= PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos= instituicaoEnsinoRepo.findByNivelEnsinoId(id, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);
    }

    //buscar instituicoes de ensino pela designacao do nivel de ensino
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesDeEnsinoPelaDesignacaoDoNivel(String designacao, int size, Sort sort, int page){
        Pageable pageable=PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos= instituicaoEnsinoRepo.findByNivelEnsinoDesignacaoContainingIgnoreCase(designacao, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);
    }

    //listar pelo id da provincia
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesEnsinoPeloIdProvincia(Long id, Sort sort, int size, int page){
        Pageable pageable= PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos= instituicaoEnsinoRepo.findByProvinciaId(id, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino :: toDTO);
    }

    //listar instituicoes de ensino pela designacao da provincia
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesDeEnsinoPelaDesignacaoDaProvincia(String designacao, int size, int page, Sort sort){
        Pageable pageable= PageRequest.of(page, size,sort );
        Page<InstituicaoEnsino> instituicaoEnsinos=instituicaoEnsinoRepo.findByProvinciaDesignacaoContainingIgnoreCase(designacao, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);
    }

    //Listar Instituicoes de ensino pela id da provincia e nivel de ensino
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicoesDeEnsinoPeloIdDoNivelDeEnsinoEIdDProvincia(Long idNivelEnsino, Long idProvincia, Sort sort, int size, int page){
        Pageable pageable=PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos = instituicaoEnsinoRepo.findByNivelEnsinoIdAndProvinciaId(idNivelEnsino, idProvincia, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);

    }

    //listar instituicoes de ensino pela designacao do nivel de ensino e provincia
    public Page<InstituicaoEnsinoRespostaDTO> listarInstituicaoEnsinoPelaDesignacaoProvinciaEDesignacaoNivelEnsino(String provincia, String nivelEnsino, Sort sort, int size, int page){
        Pageable pageable=PageRequest.of(page, size, sort);
        Page<InstituicaoEnsino> instituicaoEnsinos=instituicaoEnsinoRepo.findByNivelEnsinoDesignacaoContainingIgnoreCaseAndProvinciaDesignacaoContainingIgnoreCase(nivelEnsino, provincia, pageable);
        return instituicaoEnsinos.map(InstituicaoEnsino::toDTO);
    }


}
