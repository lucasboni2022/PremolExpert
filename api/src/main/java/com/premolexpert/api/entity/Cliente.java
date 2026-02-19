package com.premolexpert.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tbcliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "tbcliente_cliid_seq", allocationSize = 1)
    @Column(name = "cliid")
    private Integer cliId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pesid")
    private Pessoa pessoa;

    @Column(name = "cliobs", columnDefinition = "TEXT")
    private String cliObs;

    @Column(name = "cliincpor")
    private Integer cliIncPor;

    @Column(name = "cliincem")
    private LocalDateTime cliIncEm;

    @Column(name = "clialtpor")
    private Integer cliAltPor;

    @Column(name = "clialtem")
    private LocalDateTime cliAltEm;

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCliObs() {
        return cliObs;
    }

    public void setCliObs(String cliObs) {
        this.cliObs = cliObs;
    }

    public Integer getCliIncPor() {
        return cliIncPor;
    }

    public void setCliIncPor(Integer cliIncPor) {
        this.cliIncPor = cliIncPor;
    }

    public LocalDateTime getCliIncEm() {
        return cliIncEm;
    }

    public void setCliIncEm(LocalDateTime cliIncEm) {
        this.cliIncEm = cliIncEm;
    }

    public Integer getCliAltPor() {
        return cliAltPor;
    }

    public void setCliAltPor(Integer cliAltPor) {
        this.cliAltPor = cliAltPor;
    }

    public LocalDateTime getCliAltEm() {
        return cliAltEm;
    }

    public void setCliAltEm(LocalDateTime cliAltEm) {
        this.cliAltEm = cliAltEm;
    }
}
