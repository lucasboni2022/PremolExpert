package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbestado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_seq")
    @SequenceGenerator(name = "estado_seq", sequenceName = "tbestado_estid_seq", allocationSize = 1)
    @Column(name = "estid", nullable = false)
    private Integer estId;

    @Column(name = "estnom", length = 100, nullable = false)
    private String estNom;

    @Column(name = "estsigla", length = 2, nullable = false)
    private String estSigla;

    @Column(name = "paisid")
    private Integer paisId;

    @Column(name = "estincpor")
    private Integer estIncPor;

    @Column(name = "estincem")
    private LocalDateTime estIncEm;

    @Column(name = "estaltpor")
    private Integer estAltPor;

    @Column(name = "estaltem")
    private LocalDateTime estAltEm;

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNom() {
        return estNom;
    }

    public void setEstNom(String estNom) {
        this.estNom = estNom;
    }

    public String getEstSigla() {
        return estSigla;
    }

    public void setEstSigla(String estSigla) {
        this.estSigla = estSigla;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public Integer getEstIncPor() {
        return estIncPor;
    }

    public void setEstIncPor(Integer estIncPor) {
        this.estIncPor = estIncPor;
    }

    public LocalDateTime getEstIncEm() {
        return estIncEm;
    }

    public void setEstIncEm(LocalDateTime estIncEm) {
        this.estIncEm = estIncEm;
    }

    public Integer getEstAltPor() {
        return estAltPor;
    }

    public void setEstAltPor(Integer estAltPor) {
        this.estAltPor = estAltPor;
    }

    public LocalDateTime getEstAltEm() {
        return estAltEm;
    }

    public void setEstAltEm(LocalDateTime estAltEm) {
        this.estAltEm = estAltEm;
    }
}
