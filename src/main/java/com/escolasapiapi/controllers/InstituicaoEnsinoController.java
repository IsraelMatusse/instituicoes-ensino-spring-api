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
        Sort.Direction direction= order.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        Sort sort= Sort.by(order, filter);

        Page<InstituicaoEnsinoRespostaDTO> instituicaoEnsinoRespostaDTOPage= instituicaoEnsinoService.listarInstituicoesEnsinoPag(size, page, sort);
        ResponseAPI response = new ResponseAPI(true,"Instituicoes de ensino do sistema", instituicaoEnsinoRespostaDTOPage );

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
}
