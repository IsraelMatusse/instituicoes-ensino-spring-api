package com.escolasapiapi.dtos.provinciaDTOs;

import com.escolasapiapi.models.Provincia;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProvinciaRespostaDTO {
    private String designacao;
    private String codigo;
    private Long id;

    public ProvinciaRespostaDTO(Provincia provincia){
        this.codigo=provincia.getCodigo();
        this.designacao=provincia.getDesignacao();
        this.id=provincia.getId();
    }
}
