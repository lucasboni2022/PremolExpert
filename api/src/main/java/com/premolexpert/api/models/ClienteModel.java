package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbcliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "tbcliente_cliid_seq", allocationSize = 1)
    @Column(name = "cliid", nullable = false)
    private Integer cliId;

    @OneToOne
    @JoinColumn(name = "pesid", nullable = false, referencedColumnName = "pesid", unique = true)
    private PessoaModel pessoa;

    @Column(name = "cliobs", length = 200)
    private String cliObs;

    @Column(name = "cliincpor", nullable = false)
    private Integer cliIncPor;

    @Column(name = "cliincem", nullable = false)
    private LocalDate cliIncEm;

    @Column(name = "clialtpor")
    private Integer cliAltPor;

    @Column(name = "clialtem")
    private LocalDate cliAltEm;

    // Getters e Setters
    public Integer getCliId() { return cliId; }
    public void setCliId(Integer cliId) { this.cliId = cliId; }

    public PessoaModel getPessoa() { return pessoa; }
    public void setPessoa(PessoaModel pessoa) { this.pessoa = pessoa; }

    public String getPesNom() { return pessoa != null ? pessoa.getPesNom() : null; }

    public String getCliObs() { return cliObs; }
    public void setCliObs(String cliObs) { this.cliObs = cliObs; }

    public Integer getCliIncPor() { return cliIncPor; }
    public void setCliIncPor(Integer cliIncPor) { this.cliIncPor = cliIncPor; }

    public LocalDate getCliIncEm() { return cliIncEm; }
    public void setCliIncEm(LocalDate cliIncEm) { this.cliIncEm = cliIncEm; }

    public Integer getCliAltPor() { return cliAltPor; }
    public void setCliAltPor(Integer cliAltPor) { this.cliAltPor = cliAltPor; }

    public LocalDate getCliAltEm() { return cliAltEm; }
    public void setCliAltEm(LocalDate cliAltEm) { this.cliAltEm = cliAltEm; }

}
