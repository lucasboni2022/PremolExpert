package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbtela")
public class Tela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tela_seq")
    @SequenceGenerator(name = "tela_seq", sequenceName = "tbtela_telid_seq", allocationSize = 1)
    @Column(name = "telid", nullable = false)
    private Integer telId;

    @Column(name = "telnom", length = 100, nullable = false)
    private String telNom;

    @Column(name = "telincpor")
    private Integer telIncPor;

    @Column(name = "telincem")
    private LocalDateTime telIncEm;

    @Column(name = "telaltpor")
    private Integer telAltPor;

    @Column(name = "telaltem")
    private LocalDateTime telAltEm;

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getTelNom() {
        return telNom;
    }

    public void setTelNom(String telNom) {
        this.telNom = telNom;
    }

    public Integer getTelIncPor() {
        return telIncPor;
    }

    public void setTelIncPor(Integer telIncPor) {
        this.telIncPor = telIncPor;
    }

    public LocalDateTime getTelIncEm() {
        return telIncEm;
    }

    public void setTelIncEm(LocalDateTime telIncEm) {
        this.telIncEm = telIncEm;
    }

    public Integer getTelAltPor() {
        return telAltPor;
    }

    public void setTelAltPor(Integer telAltPor) {
        this.telAltPor = telAltPor;
    }

    public LocalDateTime getTelAltEm() {
        return telAltEm;
    }

    public void setTelAltEm(LocalDateTime telAltEm) {
        this.telAltEm = telAltEm;
    }
}
