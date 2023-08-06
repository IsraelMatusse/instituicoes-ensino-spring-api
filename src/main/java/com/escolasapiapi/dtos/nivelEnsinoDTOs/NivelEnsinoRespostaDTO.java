package com.escolasapiapi.dtos.nivelEnsinoDTOs;

import com.escolasapiapi.models.NivelEnsino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelEnsinoRespostaDTO {

    private String codigo;
    private Long id;
    private String designacao;

    public NivelEnsinoRespostaDTO(NivelEnsino nivelEnsino) {
        this.codigo=nivelEnsino.getCodigo();
        this.id=nivelEnsino.getId();
        this.designacao=nivelEnsino.getDesignacao();
    }
}
