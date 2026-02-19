package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbfuncionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    @SequenceGenerator(name = "funcionario_seq", sequenceName = "tbfuncionario_funcioid_seq", allocationSize = 1)
    @Column(name = "funcioid")
    private Integer funcioId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pesid")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "funcioobs", columnDefinition = "TEXT")
    private String funcioObs;

    @Column(name = "funcioincpor")
    private Integer funcioIncPor;

    @Column(name = "funcioincem")
    private LocalDateTime funcioIncEm;

    @Column(name = "funcioaltpor")
    private Integer funcioAltPor;

    @Column(name = "funcioaltem")
    private LocalDateTime funcioAltEm;

    public Integer getFuncioId() {
        return funcioId;
    }

    public void setFuncioId(Integer funcioId) {
        this.funcioId = funcioId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getPesId() {
        return pessoa != null ? pessoa.getPesId() : null;
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

    public String getFuncioObs() {
        return funcioObs;
    }

    public void setFuncioObs(String funcioObs) {
        this.funcioObs = funcioObs;
    }

    public Integer getFuncioIncPor() {
        return funcioIncPor;
    }

    public void setFuncioIncPor(Integer funcioIncPor) {
        this.funcioIncPor = funcioIncPor;
    }

    public LocalDateTime getFuncioIncEm() {
        return funcioIncEm;
    }

    public void setFuncioIncEm(LocalDateTime funcioIncEm) {
        this.funcioIncEm = funcioIncEm;
    }

    public Integer getFuncioAltPor() {
        return funcioAltPor;
    }

    public void setFuncioAltPor(Integer funcioAltPor) {
        this.funcioAltPor = funcioAltPor;
    }

    public LocalDateTime getFuncioAltEm() {
        return funcioAltEm;
    }

    public void setFuncioAltEm(LocalDateTime funcioAltEm) {
        this.funcioAltEm = funcioAltEm;
    }
}
