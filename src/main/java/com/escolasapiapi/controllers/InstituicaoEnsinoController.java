package com.escolasapiapi.controllers;

import com.escolasapiapi.dtos.ResponseAPI;
import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoRespostaDTO;
import com.escolasapiapi.services.InstituicaoEnsinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicoes-ensino")
@RequiredArgsConstructor
public class InstituicaoEnsinoController {

    private final InstituicaoEnsinoService instituicaoEnsinoService;

    @GetMapping
    public ResponseEntity<ResponseAPI> listarTodasInstituicoesDeEnsino(
            @RequestParam( defaultValue = "10") int size,
            @RequestParam(defaultValue = "0" )int page,
            @RequestParam(defaultValue = "desc")String order,
            @RequestParam(defaultValue = "designacao") String filter
            ){
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, filter); // Use direction and filter for sorting

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage = instituicaoEnsinoService.listarInstituicoesEnsinoPag(size, page, sort);        ResponseAPI response = new ResponseAPI(true,"Instituicoes de ensino do sistema", instituicaoEnsinoRespostaDTOPage );

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/nivel-ensino/{id}")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPeloNivel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @PathVariable(value = "id") Long id
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesDeEnsinoPeloIdDoNivel( id, sort,size, page);
        ResponseAPI response= new ResponseAPI(true, "Instituicos de ensino do nivel de id" + id, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/nivel-ensino/{designacao}")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPelaDesignacaoDoNivel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @PathVariable(value = "designacao") String designacao
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesDeEnsinoPelaDesignacaoDoNivel( designacao,size, sort, page);
        ResponseAPI response= new ResponseAPI(true, "Instituicos de ensino do nivel " + designacao, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/provincia-id/{id-provincia}")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPeloIdDaProvincia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @PathVariable(value = "id-provincia") Long idProvincia
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesEnsinoPeloIdProvincia( idProvincia,sort, size, page);
        ResponseAPI response= new ResponseAPI(true, "Instituicos da provincia com id " + idProvincia, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/provincia")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPelaDesignacaoDaProvincia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @RequestParam(value = "designacao") String designacao
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesDeEnsinoPelaDesignacaoDaProvincia( designacao,page, size, sort);
        ResponseAPI response= new ResponseAPI(true, "Instituicos da provincia com a designacao" + designacao, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }
    @GetMapping("/nivel-ensino/{id-nivel}/provincia/{id-provincia}")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPeloIdDoNivelEIdDaProvincia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @PathVariable(value = "id-nivel") Long idNivel,
            @PathVariable(value = "id-provincia") Long idProvincia
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesDeEnsinoPeloIdDoNivelDeEnsinoEIdDProvincia( idNivel,idProvincia,sort, size, page);
        ResponseAPI response= new ResponseAPI(true, "Instituicos da provincia com o id " + idProvincia + "e nivel de ensino " + idNivel, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/provincia/{designacao-provincia}/nivel-ensino/{designacao-nivel}")
    public ResponseEntity<ResponseAPI> listarInstituicoesEninoPelaDesignacaoDoNivelDeEnsinoEDesignacaoDaProvincia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "designacao") String filter,
            @PathVariable(value = "designacao-nivel-") String designacaoNivel,
            @PathVariable(value = "designacao-provincia") String designacaoProvincia
    ){
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(direction, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicaoEnsinoPelaDesignacaoProvinciaEDesignacaoNivelEnsino( designacaoProvincia,designacaoNivel,sort, size, page);
        ResponseAPI response= new ResponseAPI(true, "Instituicos da provincia com a desginacao " + designacaoProvincia + "e nivel de ensino " + designacaoNivel, instituicaoEnsinoRespostaDTOPage);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Total Elements", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalElements()));
        headers.add("Total Pages", String.valueOf(instituicaoEnsinoRespostaDTOPage.getTotalPages()));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }
}
