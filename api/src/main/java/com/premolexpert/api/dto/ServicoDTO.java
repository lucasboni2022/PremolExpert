package com.premolexpert.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ServicoDTO {

    private Integer serId;
    private String serDesc;
    private String serFabricacao;
    private BigDecimal serSessaoLargura;
    private BigDecimal serSessaoComprimento;
    private BigDecimal serSessaoAltura;
    private Integer empId;
    private LocalDateTime serIncEm;
    private Integer serIncPor;
    private LocalDateTime serAltEm;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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
