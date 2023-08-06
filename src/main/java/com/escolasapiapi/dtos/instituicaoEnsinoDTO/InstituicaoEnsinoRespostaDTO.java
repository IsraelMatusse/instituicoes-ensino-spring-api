package com.escolasapiapi.dtos.instituicaoEnsinoDTO;

import com.escolasapiapi.models.InstituicaoEnsino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class InstituicaoEnsinoRespostaDTO {

   private String designacao;
   private String codigo;
   private  String provincia;
   private  String nivelEnsino;
    public InstituicaoEnsinoRespostaDTO(InstituicaoEnsino instituicaoEnsino){
        this.codigo=instituicaoEnsino.getCodigo();
        this.nivelEnsino=instituicaoEnsino.getNivelEnsino().getDesignacao();
        this.designacao=instituicaoEnsino.getDesignacao();
        this.provincia=instituicaoEnsino.getProvincia().getDesignacao();
    }
}
