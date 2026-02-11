package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbservico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_seq")
    @SequenceGenerator(name = "servico_seq", sequenceName = "tbservico_serid_seq", allocationSize = 1)
    @Column(name = "serid", nullable = false)
    private Integer serId;

    @Column(name = "serdesc", columnDefinition = "TEXT", nullable = false)
    private String serDesc;

    @Column(name = "serfabricacao", columnDefinition = "TEXT", nullable = false)
    private String serFabricacao;

    @Column(name = "sersessaolargura", precision = 5, scale = 2)
    private BigDecimal serSessaoLargura;

    @Column(name = "serSessaoComprimento", precision = 5, scale = 2)
    private BigDecimal serSessaoComprimento;

    @Column(name = "sersessaoaltura", precision = 5, scale = 2)
    private BigDecimal serSessaoAltura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "serincem")
    private LocalDateTime serIncEm;

    @Column(name = "serincpor")
    private Integer serIncPor;

    @Column(name = "seraltem")
    private LocalDateTime serAltEm;

    @Column(name = "seraltpor")
    private UUID serAltPor;

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerDesc() {
        return serDesc;
    }

    public void setSerDesc(String serDesc) {
        this.serDesc = serDesc;
    }

    public String getSerFabricacao() {
        return serFabricacao;
    }

    public void setSerFabricacao(String serFabricacao) {
        this.serFabricacao = serFabricacao;
    }

    public BigDecimal getSerSessaoLargura() {
        return serSessaoLargura;
    }

    public void setSerSessaoLargura(BigDecimal serSessaoLargura) {
        this.serSessaoLargura = serSessaoLargura;
    }

    public BigDecimal getSerSessaoComprimento() {
        return serSessaoComprimento;
    }

    public void setSerSessaoComprimento(BigDecimal serSessaoComprimento) {
        this.serSessaoComprimento = serSessaoComprimento;
    }

    public BigDecimal getSerSessaoAltura() {
        return serSessaoAltura;
    }

    public void setSerSessaoAltura(BigDecimal serSessaoAltura) {
        this.serSessaoAltura = serSessaoAltura;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getSerIncEm() {
        return serIncEm;
    }

    public void setSerIncEm(LocalDateTime serIncEm) {
        this.serIncEm = serIncEm;
    }

    public Integer getSerIncPor() {
        return serIncPor;
    }

    public void setSerIncPor(Integer serIncPor) {
        this.serIncPor = serIncPor;
    }

    public LocalDateTime getSerAltEm() {
        return serAltEm;
    }

    public void setSerAltEm(LocalDateTime serAltEm) {
        this.serAltEm = serAltEm;
    }

    public UUID getSerAltPor() {
        return serAltPor;
    }

    public void setSerAltPor(UUID serAltPor) {
        this.serAltPor = serAltPor;
    }
}
