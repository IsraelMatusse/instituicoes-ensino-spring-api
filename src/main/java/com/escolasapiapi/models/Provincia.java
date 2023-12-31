package com.escolasapiapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provincia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String designacao;
    private String sigla;
    private String codigo;

    @ManyToOne
    private ZonaRegional zonaRegional;
}
