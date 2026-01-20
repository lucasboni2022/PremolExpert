package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbfuncionario")
@PrimaryKeyJoinColumn(name = "funcioid") // PK = FK para Pessoa
public class Funcionario extends Pessoa {
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcio_seq")
   // @SequenceGenerator(name = "funcionario_seq", sequenceName = "tbfuncionario_funcioid_seq", allocationSize = 1)
   // @Column(name = "funcioid", nullable = false)
   // private Integer funcioId;

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

    // Getters e Setters
    public String getFuncioObs() { return funcioObs; }
    public void setFuncioObs(String funcioObs) { this.funcioObs = funcioObs; }

    public Integer getFuncioIncPor() { return funcioIncPor; }
    public void setFuncioIncPor(Integer funcioIncPor) { this.funcioIncPor = funcioIncPor; }

    public LocalDateTime getFuncioIncEm() { return funcioIncEm; }
    public void setFuncioIncEm(LocalDateTime funcioIncEm) { this.funcioIncEm = funcioIncEm; }

    public Integer getFuncioAltPor() { return funcioAltPor; }
    public void setFuncioAltPor(Integer funcioAltPor) { this.funcioAltPor = funcioAltPor; }

    public LocalDateTime getFuncioAltEm() { return funcioAltEm; }
    public void setFuncioAltEm(LocalDateTime funcioAltEm) { this.funcioAltEm = funcioAltEm; }
}
