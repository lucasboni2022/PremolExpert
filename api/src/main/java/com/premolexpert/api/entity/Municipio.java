package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbmunicipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_seq")
    @SequenceGenerator(name = "municipio_seq", sequenceName = "tbmunicipio_munid_seq", allocationSize = 1)
    @Column(name = "munid", nullable = false)
    private Integer munId;

    @Column(name = "munnom", length = 100, nullable = false)
    private String munNom;

    @ManyToOne
    @JoinColumn(name = "empid")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "munmunorigid")
    private Municipio municipioOrigem;

    @Column(name = "munativo")
    private Boolean munAtivo = true;

    @Column(name = "munincpor")
    private Integer munIncPor;

    @Column(name = "munincem")
    private LocalDateTime munIncEm;

    @Column(name = "munaltpor")
    private Integer munAltPor;

    @Column(name = "munaltem")
    private LocalDateTime munAltEm;

    @ManyToOne()
    @JoinColumn(name = "estid")
    private Estado estado;

    public Integer getMunId() {
        return munId;
    }

    public void setMunId(Integer munId) {
        this.munId = munId;
    }

    public String getMunNom() {
        return munNom;
    }

    public void setMunNom(String munNom) {
        this.munNom = munNom;
    }

    public Integer getEstId() {
        return estado != null ? estado.getEstId() : null;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpId() {
        return empresa != null ? empresa.getEmpId() : null;
    }

    public Municipio getMunicipioOrigem() {
        return municipioOrigem;
    }

    public void setMunicipioOrigem(Municipio municipioOrigem) {
        this.municipioOrigem = municipioOrigem;
    }

    public Integer getMunMunOrigId() {
        return municipioOrigem != null ? municipioOrigem.getMunId() : null;
    }

    public Boolean getMunAtivo() {
        return munAtivo;
    }

    public void setMunAtivo(Boolean munAtivo) {
        this.munAtivo = munAtivo;
    }

    public Integer getMunIncPor() {
        return munIncPor;
    }

    public void setMunIncPor(Integer munIncPor) {
        this.munIncPor = munIncPor;
    }

    public LocalDateTime getMunIncEm() {
        return munIncEm;
    }

    public void setMunIncEm(LocalDateTime munIncEm) {
        this.munIncEm = munIncEm;
    }

    public Integer getMunAltPor() {
        return munAltPor;
    }

    public void setMunAltPor(Integer munAltPor) {
        this.munAltPor = munAltPor;
    }

    public LocalDateTime getMunAltEm() {
        return munAltEm;
    }

    public void setMunAltEm(LocalDateTime munAltEm) {
        this.munAltEm = munAltEm;
    }
}
