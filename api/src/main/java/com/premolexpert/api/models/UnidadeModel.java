package com.premolexpert.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbunidade")
public class UnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uniade_seq")
    @SequenceGenerator(name = "uniade_seq", sequenceName = "tbuniade_uni_seq", allocationSize = 1)
    @Column(name = "uniid", nullable = false)
    private Integer uniId;

    @Column(name = "uninom", nullable = false)
    private String uniNom;

    @Column(name = "uniincpor", nullable = false)
    private Integer uniIncPor;

    @Column(name = "uniincem", nullable = false)
    private LocalDate uniIncEm;

    @Column(name = "unialtpor")
    private Integer uniAltPor;

    @Column(name = "unialtem")
    private LocalDate uniAltEm;

    // Default no-argument constructor for JPA
    public UnidadeModel() {
        // No-argument constructor required by JPA
    }

    // Construtor específico para deserialização de prodId
    @JsonCreator
    public UnidadeModel(@JsonProperty("uniId") Integer uniId){
        this.uniId = uniId;
    }

    // Getters e Setters
    public Integer getUniId() { return uniId; }
    public void setUniId(Integer uni) { this.uniId = uni; }

    public String getUniNom() { return uniNom; }
    public void setUniNom(String uniNom) { this.uniNom = uniNom; }

    public Integer getUniIncPor() { return uniIncPor; }
    public void setUniIncPor(Integer uniIncPor) { this.uniIncPor = uniIncPor; }

    public LocalDate getUniIncEm() { return uniIncEm; }
    public void setUniIncEm(LocalDate uniIncEm) { this.uniIncEm = uniIncEm; }

    public Integer getUniAltPor() { return uniAltPor; }
    public void setUniAltPor(Integer uniAltPor) { this.uniAltPor = uniAltPor; }

    public LocalDate getUniAltEm() { return uniAltEm; }
    public void setUniAltEm(LocalDate uniAltEm) { this.uniAltEm = uniAltEm; }
}