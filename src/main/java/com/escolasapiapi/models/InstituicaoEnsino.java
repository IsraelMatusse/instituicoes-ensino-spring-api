package com.escolasapiapi.models;


import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoCriarDTO;
import com.escolasapiapi.dtos.instituicaoEnsinoDTO.InstituicaoEnsinoRespostaDTO;
import com.escolasapiapi.utils.GeneratePin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InstituicaoEnsino {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String designacao;
    private String codigo;
    private String sigla;

    @ManyToMany
    private NivelEnsino nivelEnsino;
    @ManyToMany
    private Provincia provincia;

    public InstituicaoEnsino(InstituicaoEnsinoCriarDTO dto, Provincia provincia, NivelEnsino nivelEnsino) throws NoSuchAlgorithmException {
        this.codigo= GeneratePin.generateStringPin();
        this.designacao= dto.designacao();
        this.sigla=dto.sigla();
        this.provincia=provincia;
        this.nivelEnsino=nivelEnsino;
    }

}
