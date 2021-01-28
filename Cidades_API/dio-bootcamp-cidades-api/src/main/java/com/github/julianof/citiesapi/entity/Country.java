package com.github.julianof.citiesapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "pais")
public class Country {

    @Id
    private Long id;
    
    @Column(name = "nome")
    private String name;
    
    @Column(name = "nome_pt")
    private String portugueseName;
    
    @Column(name = "sigla")
    private String code;
    
    private Integer bacen;
}
