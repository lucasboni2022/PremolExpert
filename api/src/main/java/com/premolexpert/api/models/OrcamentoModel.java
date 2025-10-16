package com.premolexpert.api.models;

import com.premolexpert.api.enums.OrcEtapEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamento")
public class OrcamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orcid", nullable = false)
    public Integer orcId;

    @Column(name = "orcnumproemp", nullable = false)
    private Integer orcNumProEmp;

    @OneToOne
    @JoinColumn(name = "cliid", referencedColumnName = "cliid",nullable = false)
    private ClienteModel cliente;

    @Column(name = "orcnomobr", length = 255)
    private String orcNomObr;

    @Column(name = "orcdatsol")
    private Date orcDatSol;

    @Column(name = "orcdtaprevent")
    private Date orcDtaPrevEnt;

    @Column(name = "orcdimtam", length = 100)
    private String orcDimTam;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "orcetap", nullable = false)
    private OrcEtapEnum orcEtap;

    @Column(name = "orcdatentpro")
    private Date orcDatEntPro;

    @Column(name = "orcqtddiaresent")
    private Integer orcQtdDiaResEnt;

    @Column(name = "orcvalped", precision = 18, scale = 2)
    private BigDecimal orcValPed;

    @Column(name = "orcsalneg", precision = 18, scale = 2)
    private BigDecimal orcSalNeg;

    @Column(name = "orcpesorc", precision = 18, scale = 2)
    private BigDecimal orcPesOrc;

    @Column(name = "orcpesexe", precision = 18, scale = 2)
    private BigDecimal orcPesExe;

    @Column(name = "orcsalpes", precision = 18, scale = 2)
    private BigDecimal orcSalPes;

    @Column(name = "orcincpor", nullable = false)
    private Integer orcIncPor;

    @Column(name = "orcincem", nullable = false)
    private LocalDateTime orcIncEm;

    @Column(name = "orcaltpor")
    private Integer orcAltPor;

    @Column(name = "orcaltem")
    private LocalDateTime orcAltEm;

    @Column(name = "empid", nullable = false)
    private Integer empId;

    @Column(name = "orcpaiorcid")
    private Integer orcPaiOrcId;

    // Getters e Setters

    public Integer getOrcId() {
        return orcId;
    }

    public void setOrcId(Integer orcId) {
        this.orcId = orcId;
    }

    public Integer getOrcNumProEmp() {
        return orcNumProEmp;
    }

    public void setOrcNumProEmp(Integer orcNumProEmp) {
        this.orcNumProEmp = orcNumProEmp;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getOrcNomObr() {
        return orcNomObr;
    }

    public void setOrcNomObr(String orcNomObr) {
        this.orcNomObr = orcNomObr;
    }

    public Date getOrcDatSol() {
        return orcDatSol;
    }

    public void setOrcDatSol(Date orcDatSol) {
        this.orcDatSol = orcDatSol;
    }

    public Date getOrcDtaPrevEnt() {
        return orcDtaPrevEnt;
    }

    public void setOrcDtaPrevEnt(Date orcDtaPrevEnt) {
        this.orcDtaPrevEnt = orcDtaPrevEnt;
    }

    public String getOrcDimTam() {
        return orcDimTam;
    }

    public void setOrcDimTam(String orcDimTam) {
        this.orcDimTam = orcDimTam;
    }

    public OrcEtapEnum getOrcEtap() {
        return orcEtap;
    }

    public void setOrcEtap(OrcEtapEnum orcEtap) {
        this.orcEtap = orcEtap;
    }

    public String getDescricaoEtapaProcesso() {
        return orcEtap != null ? orcEtap.getDescricao() : null;
    }

    public Date getOrcDatEntPro() {
        return orcDatEntPro;
    }

    public void setOrcDatEntPro(Date orcDatEntPro) {
        this.orcDatEntPro = orcDatEntPro;
    }

    public Integer getOrcQtdDiaResEnt() {
        return orcQtdDiaResEnt;
    }

    public void setOrcQtdDiaResEnt(Integer orcQtdDiaResEnt) {
        this.orcQtdDiaResEnt = orcQtdDiaResEnt;
    }

    public BigDecimal getOrcValPed() {
        return orcValPed;
    }

    public void setOrcValPed(BigDecimal orcValPed) {
        this.orcValPed = orcValPed;
    }

    public BigDecimal getOrcSalNeg() {
        return orcSalNeg;
    }

    public void setOrcSalNeg(BigDecimal orcSalNeg) {
        this.orcSalNeg = orcSalNeg;
    }

    public BigDecimal getOrcPesOrc() {
        return orcPesOrc;
    }

    public void setOrcPesOrc(BigDecimal orcPesOrc) {
        this.orcPesOrc = orcPesOrc;
    }

    public BigDecimal getOrcPesExe() {
        return orcPesExe;
    }

    public void setOrcPesExe(BigDecimal orcPesExe) {
        this.orcPesExe = orcPesExe;
    }

    public BigDecimal getOrcSalPes() {
        return orcSalPes;
    }

    public void setOrcSalPes(BigDecimal orcSalPes) {
        this.orcSalPes = orcSalPes;
    }

    public Integer getOrcIncPor() {
        return orcIncPor;
    }

    public void setOrcIncPor(Integer orcIncPor) {
        this.orcIncPor = orcIncPor;
    }

    public LocalDateTime getOrcIncEm() {
        return orcIncEm;
    }

    public void setOrcIncEm(LocalDateTime orcIncEm) {
        this.orcIncEm = orcIncEm;
    }

    public Integer getOrcAltPor() {
        return orcAltPor;
    }

    public void setOrcAltPor(Integer orcAltPor) {
        this.orcAltPor = orcAltPor;
    }

    public LocalDateTime getOrcAltEm() {
        return orcAltEm;
    }

    public void setOrcAltEm(LocalDateTime orcAltEm) {
        this.orcAltEm = orcAltEm;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getOrcPaiorcId() {
        return orcPaiOrcId;
    }

    public void setOrcPaiorcId(Integer orcPaiorcId) {
        this.orcPaiOrcId = orcPaiorcId;
    }
}

/* Observações
//@Enumerated(EnumType.ORDINAL) //padrao...0,1,2,3,etc, comentado ou nao usa esse padrao.
@Column(name = "orcEtap", nullable = false)
private orcEtapEnum orcEtap;

public void setOrcEtap(orcEtapEnum codigoEtapa) {
    this.orcEtap = codigoEtapa;
}

essa outra forma coloca o numero que vc coloca no enum:
    public void setOrcEtap(Integer codigoEtapa) {
        this.orcEtap = orcEtapEnum.fromCodigo(codigoEtapa);
    }
 */
