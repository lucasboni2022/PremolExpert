package com.premolexpert.api.dto;

import com.premolexpert.api.enumeration.OrcPedEtapEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrcamentoPedidoDTO {

    private Integer orcPedId;
    private String orcPedNumPro;
    private Integer cliId;
    private String orcPedNomObr;
    private LocalDate orcPedDatSol;
    private LocalDate orcPedDtaPrevEnt;
    private String orcPedDimTam;
    private Integer usuId;
    private OrcPedEtapEnum orcPedEtapa;
    private BigDecimal orcPedValOrc;
    private LocalDate orcPedDatEntPro;
    private Integer orcPedQtdDiaResEnt;
    private BigDecimal orcPedValPed;
    private BigDecimal orcPedSalNeg;
    private BigDecimal orcPedPesOrc;
    private BigDecimal orcPedPesExe;
    private BigDecimal orcPedSalPes;
    private Integer empId;
    private Integer orcPedPaiId;
    private Integer orcPedIncPor;
    private LocalDateTime orcPedIncEm;
    private Integer orcPedAltPor;
    private LocalDateTime orcPedAltEm;

    public Integer getOrcPedId() {
        return orcPedId;
    }

    public void setOrcPedId(Integer orcPedId) {
        this.orcPedId = orcPedId;
    }

    public String getOrcPedNumPro() {
        return orcPedNumPro;
    }

    public void setOrcPedNumPro(String orcPedNumPro) {
        this.orcPedNumPro = orcPedNumPro;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getOrcPedNomObr() {
        return orcPedNomObr;
    }

    public void setOrcPedNomObr(String orcPedNomObr) {
        this.orcPedNomObr = orcPedNomObr;
    }

    public LocalDate getOrcPedDatSol() {
        return orcPedDatSol;
    }

    public void setOrcPedDatSol(LocalDate orcPedDatSol) {
        this.orcPedDatSol = orcPedDatSol;
    }

    public LocalDate getOrcPedDtaPrevEnt() {
        return orcPedDtaPrevEnt;
    }

    public void setOrcPedDtaPrevEnt(LocalDate orcPedDtaPrevEnt) {
        this.orcPedDtaPrevEnt = orcPedDtaPrevEnt;
    }

    public String getOrcPedDimTam() {
        return orcPedDimTam;
    }

    public void setOrcPedDimTam(String orcPedDimTam) {
        this.orcPedDimTam = orcPedDimTam;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public OrcPedEtapEnum getOrcPedEtapa() {
        return orcPedEtapa;
    }

    public void setOrcPedEtapa(OrcPedEtapEnum orcPedEtapa) {
        this.orcPedEtapa = orcPedEtapa;
    }

    public BigDecimal getOrcPedValOrc() {
        return orcPedValOrc;
    }

    public void setOrcPedValOrc(BigDecimal orcPedValOrc) {
        this.orcPedValOrc = orcPedValOrc;
    }

    public LocalDate getOrcPedDatEntPro() {
        return orcPedDatEntPro;
    }

    public void setOrcPedDatEntPro(LocalDate orcPedDatEntPro) {
        this.orcPedDatEntPro = orcPedDatEntPro;
    }

    public Integer getOrcPedQtdDiaResEnt() {
        return orcPedQtdDiaResEnt;
    }

    public void setOrcPedQtdDiaResEnt(Integer orcPedQtdDiaResEnt) {
        this.orcPedQtdDiaResEnt = orcPedQtdDiaResEnt;
    }

    public BigDecimal getOrcPedValPed() {
        return orcPedValPed;
    }

    public void setOrcPedValPed(BigDecimal orcPedValPed) {
        this.orcPedValPed = orcPedValPed;
    }

    public BigDecimal getOrcPedSalNeg() {
        return orcPedSalNeg;
    }

    public void setOrcPedSalNeg(BigDecimal orcPedSalNeg) {
        this.orcPedSalNeg = orcPedSalNeg;
    }

    public BigDecimal getOrcPedPesOrc() {
        return orcPedPesOrc;
    }

    public void setOrcPedPesOrc(BigDecimal orcPedPesOrc) {
        this.orcPedPesOrc = orcPedPesOrc;
    }

    public BigDecimal getOrcPedPesExe() {
        return orcPedPesExe;
    }

    public void setOrcPedPesExe(BigDecimal orcPedPesExe) {
        this.orcPedPesExe = orcPedPesExe;
    }

    public BigDecimal getOrcPedSalPes() {
        return orcPedSalPes;
    }

    public void setOrcPedSalPes(BigDecimal orcPedSalPes) {
        this.orcPedSalPes = orcPedSalPes;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getOrcPedPaiId() {
        return orcPedPaiId;
    }

    public void setOrcPedPaiId(Integer orcPedPaiId) {
        this.orcPedPaiId = orcPedPaiId;
    }

    public Integer getOrcPedIncPor() {
        return orcPedIncPor;
    }

    public void setOrcPedIncPor(Integer orcPedIncPor) {
        this.orcPedIncPor = orcPedIncPor;
    }

    public LocalDateTime getOrcPedIncEm() {
        return orcPedIncEm;
    }

    public void setOrcPedIncEm(LocalDateTime orcPedIncEm) {
        this.orcPedIncEm = orcPedIncEm;
    }

    public Integer getOrcPedAltPor() {
        return orcPedAltPor;
    }

    public void setOrcPedAltPor(Integer orcPedAltPor) {
        this.orcPedAltPor = orcPedAltPor;
    }

    public LocalDateTime getOrcPedAltEm() {
        return orcPedAltEm;
    }

    public void setOrcPedAltEm(LocalDateTime orcPedAltEm) {
        this.orcPedAltEm = orcPedAltEm;
    }
}
