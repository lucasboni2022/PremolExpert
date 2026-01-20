package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbcliente")
@PrimaryKeyJoinColumn(name = "cliid") // PK = FK para Pessoa

public class Cliente extends Pessoa {
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
  //  @SequenceGenerator(name = "empresa_seq", sequenceName = "tbcliente_cliid_seq", allocationSize = 1)
 //   @Column(name = "cliid", nullable = false)
   // private Integer cliId;

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

    // Getters e Setters
    public String getCliObs() { return cliObs; }
    public void setCliObs(String cliObs) { this.cliObs = cliObs; }

    public Integer getCliIncPor() { return cliIncPor; }
    public void setCliIncPor(Integer cliIncPor) { this.cliIncPor = cliIncPor; }

    public LocalDateTime getCliIncEm() { return cliIncEm; }
    public void setCliIncEm(LocalDateTime cliIncEm) { this.cliIncEm = cliIncEm; }

    public Integer getCliAltPor() { return cliAltPor; }
    public void setCliAltPor(Integer cliAltPor) { this.cliAltPor = cliAltPor; }

    public LocalDateTime getCliAltEm() { return cliAltEm; }
    public void setCliAltEm(LocalDateTime cliAltEm) { this.cliAltEm = cliAltEm; }
}
