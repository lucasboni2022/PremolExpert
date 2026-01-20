package com.premolexpert.api.entity;

import com.premolexpert.api.enumeration.OrcPedEtapEnum;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedido")
public class OrcamentoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedido_seq")
    @SequenceGenerator(name = "orcamentopedido_seq", sequenceName = "tborcamentopedido_orcpedid_seq", allocationSize = 1)
    @Column(name = "orcpedid", nullable = false)
    private Integer orcPedId;

    @Column(name = "orcpednumpro", length = 20)
    private String orcPedNumPro;

    @Column(name = "cliid")
    private Integer cliId;

    @Column(name = "orcpednomobr", length = 255)
    private String orcPedNomObr;

    @Column(name = "orcpeddatsol")
    private LocalDate orcPedDatSol;

    @Column(name = "orcpeddtaprevent")
    private LocalDate orcPedDtaPrevEnt;

    @Column(name = "orcpeddimtam", length = 100)
    private String orcPedDimTam;

    @Column(name = "usuid")
    private Integer usuId;

    @Column(name = "orcpedetapa")
    private OrcPedEtapEnum orcPedEtapa;

    public OrcPedEtapEnum getOrcPedEtapa() {
        return orcPedEtapa;
    }

    public void setOrcPedEtapa(OrcPedEtapEnum orcPedEtapa) {
        this.orcPedEtapa = orcPedEtapa;
    }

    @Column(name = "orcpedvalorc", precision = 18, scale = 2)
    private BigDecimal orcPedValOrc;

    @Column(name = "orcpeddatentpro")
    private LocalDate orcPedDatEntPro;

    @Column(name = "orcpedqtddiaresent")
    private Integer orcPedQtdDiaResEnt;

    @Column(name = "orcpedvalped", precision = 18, scale = 2)
    private BigDecimal orcPedValPed;

    @Column(name = "orcpedsalneg", precision = 18, scale = 2)
    private BigDecimal orcPedSalNeg;

    @Column(name = "orcpedpesorc", precision = 18, scale = 2)
    private BigDecimal orcPedPesOrc;

    @Column(name = "orcpedpesexe", precision = 18, scale = 2)
    private BigDecimal orcPedPesExe;

    @Column(name = "orcpedsalpes", precision = 18, scale = 2)
    private BigDecimal orcPedSalPes;

    @Column(name = "empid")
    private Integer empId;

    @Column(name = "orcpedpaiid")
    private Integer orcPedPaiId;

    @Column(name = "orcpedincpor")
    private Integer orcPedIncPor;

    @Column(name = "orcpedincem")
    private LocalDateTime orcPedIncEm;

    @Column(name = "orcpedaltpor")
    private Integer orcPedAltPor;

    @Column(name = "orcpedaltem")
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
