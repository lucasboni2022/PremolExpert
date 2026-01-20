package com.premolexpert.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbpais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_seq")
    @SequenceGenerator(name = "pais_seq", sequenceName = "tbpais_paisid_seq", allocationSize = 1)
    @Column(name = "paisid", nullable = false)
    private Integer paisId;

    @Column(name = "paisnom", nullable = false)
    private String paisNom;

    @Column(name = "paissigla", nullable = false)
    private String paisSigla;

    @Column(name = "paisincpor", nullable = true)
    private Integer paisIncPor;

    @Column(name = "paisincem", nullable = true)
    private LocalDateTime paisIncEm;

    @Column(name = "paisaltpor", nullable = true)
    private Integer paisAltPor;

    @Column(name = "paisaltem", nullable = true)
    private LocalDateTime paisAltEm;



    public Integer getPaisAltPor() {
        return paisAltPor;
    }

    public void setPaisAltPor(Integer paisAltPor) {
        this.paisAltPor = paisAltPor;
    }


    public Integer getPaisIncPor() {
        return paisIncPor;
    }

    public void setPaisIncPor(Integer paisIncPor) {
        this.paisIncPor = paisIncPor;
    }

    public LocalDateTime getPaisIncEm() {
        return paisIncEm;
    }

    public void setPaisIncEm(LocalDateTime paisIncEm) {
        this.paisIncEm = paisIncEm;
    }

    public LocalDateTime getPaisAltEm() {
        return paisAltEm;
    }

    public void setPaisAltEm(LocalDateTime paisAltEm) {
        this.paisAltEm = paisAltEm;
    }

    public Integer getPaisId() {
        return paisId;
    }

   public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getPaisNom() {
        return paisNom;
    }

    public void setPaisNom(String paisNom) {
        this.paisNom = paisNom;
    }

    public String getPaisSigla() {
        return paisSigla;
    }


    public void setPaisSigla(String paisSigla) {
        this.paisSigla = paisSigla;
    }


}
