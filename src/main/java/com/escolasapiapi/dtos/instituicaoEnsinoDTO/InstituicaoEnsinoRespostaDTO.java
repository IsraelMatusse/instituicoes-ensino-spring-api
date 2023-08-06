package com.escolasapiapi.dtos.instituicaoEnsinoDTO;

import com.escolasapiapi.models.InstituicaoEnsino;
import com.escolasapiapi.models.NivelEnsino;
import com.escolasapiapi.models.Provincia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class InstituicaoEnsinoRespostaDTO {

   private String designacao;
   private String sigla;
   private String codigo;
   private  String provincia;
   private  String nivelEnsino;
   private Long id;
    public InstituicaoEnsinoRespostaDTO(InstituicaoEnsino instituicaoEnsino){
        this.codigo=instituicaoEnsino.getCodigo();
        this.id=instituicaoEnsino.getId();
        this.sigla=instituicaoEnsino.getSigla();
        this.nivelEnsino=instituicaoEnsino.getNivelEnsino().getDesignacao();
        this.designacao=instituicaoEnsino.getDesignacao();
        this.provincia=instituicaoEnsino.getProvincia().getDesignacao();
    }

    public InstituicaoEnsinoRespostaDTO(String designacao, String sigla, String codigo, Long id, Provincia provincia, NivelEnsino nivelEnsino) {
        this.designacao=designacao;
        this.sigla=sigla;
        this.codigo=codigo;
        this.nivelEnsino=nivelEnsino.getDesignacao();
        this.provincia=provincia.getDesignacao();
        this.id=id;
    }
}
