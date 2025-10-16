package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentoservico")
public class OrcamentoServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_servico_seq")
    @SequenceGenerator(name = "orcamento_servico_seq", sequenceName = "tborcamentoservico_orcservid_seq", allocationSize = 1)
    @Column(name = "orcservid", nullable = false)
    private Integer orcServId;

    @Column(name = "orcid", nullable = false)
    private Integer orcId;

    @ManyToOne
    @JoinColumn(name = "servid", referencedColumnName = "servid", nullable = false)
    private ServicoModel servico;

    @OneToOne
    @JoinColumn(name = "uniid", referencedColumnName = "uniid", nullable = false)
    private UnidadeModel unidade;

    @Column(name = "orcservqtd", nullable = false)
    private Integer orcServQtd;

    @Column(name = "orcservqtdpronta", nullable = false)
    private Integer orcServQtdPronta;

    @Column(name = "orcservqtdenvafazer", nullable = false)
    private Integer orcServQtdEnvAFazer;

    @Column(name = "orcservqtdsetorarm", nullable = false)
    private Integer orcServQtdSetorArm;

    @Column(name = "orcservincpor", nullable = false)
    private Integer orcServIncPor;

    @Column(name = "orcservincem", nullable = false)
    private LocalDateTime orcServIncEm;

    @Column(name = "orcservaltpor")
    private Integer orcServAltPor;

    @Column(name = "orcservaltem")
    private LocalDateTime orcServAltEm;

    @Column(name = "orcservqtdsetorforma")
    private Integer orcServQtdSetorForma;

    @Column(name = "orcservqtdsetoracaba")
    private Integer orcServQtdSetorAcaba;

    @Column(name = "orcservordfab")
    private Integer orcServOrdFab;

    @Column(name = "orcservfabnum")
    private Integer orcServFabNum;

    public OrcamentoServicoModel() {
    }

    // Getters e Setters

    public Integer getOrcServId() {
        return orcServId;
    }

    public void setOrcServId(Integer orcServId) {
        this.orcServId = orcServId;
    }

    public Integer getOrcId() {
        return orcId;
    }

    public void setOrcId(Integer orcId) {
        this.orcId = orcId;
    }

    public ServicoModel getServico() {
        return servico;
    }

    public void setServico(ServicoModel servico) {
        this.servico = servico;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }

    public Integer getOrcServQtd() {
        return orcServQtd;
    }

    public void setOrcServQtd(Integer orcServQtd) {
        this.orcServQtd = orcServQtd;
    }

    public Integer getOrcServQtdPronta() {
        return orcServQtdPronta;
    }

    public void setOrcServQtdPronta(Integer orcServQtdPronta) {
        this.orcServQtdPronta = orcServQtdPronta;
    }

    public Integer getOrcServQtdEnvAFazer() {
        return orcServQtdEnvAFazer;
    }

    public void setOrcServQtdEnvAFazer(Integer orcServQtdEnvAFazer) {
        this.orcServQtdEnvAFazer = orcServQtdEnvAFazer;
    }

    public Integer getOrcServQtdSetorArm() {
        return orcServQtdSetorArm;
    }

    public void setOrcServQtdSetorArm(Integer orcServQtdSetorArm) {
        this.orcServQtdSetorArm = orcServQtdSetorArm;
    }

    public Integer getOrcServIncPor() {
        return orcServIncPor;
    }

    public void setOrcServIncPor(Integer orcServIncPor) {
        this.orcServIncPor = orcServIncPor;
    }

    public LocalDateTime getOrcServIncEm() {
        return orcServIncEm;
    }

    public void setOrcServIncEm(LocalDateTime orcServIncEm) {
        this.orcServIncEm = orcServIncEm;
    }

    public Integer getOrcServAltPor() {
        return orcServAltPor;
    }

    public void setOrcServAltPor(Integer orcServAltPor) {
        this.orcServAltPor = orcServAltPor;
    }

    public LocalDateTime getOrcServAltEm() {
        return orcServAltEm;
    }

    public void setOrcServAltEm(LocalDateTime orcServAltEm) {
        this.orcServAltEm = orcServAltEm;
    }

    public Integer getOrcServQtdSetorForma() {
        return orcServQtdSetorForma;
    }

    public void setOrcServQtdSetorForma(Integer orcServQtdSetorForma) {
        this.orcServQtdSetorForma = orcServQtdSetorForma;
    }

    public Integer getOrcServQtdSetorAcaba() {
        return orcServQtdSetorAcaba;
    }

    public void setOrcServQtdSetorAcaba(Integer orcServQtdSetorAcaba) {
        this.orcServQtdSetorAcaba = orcServQtdSetorAcaba;
    }

    public Integer getOrcServOrdFab() {
        return orcServOrdFab;
    }

    public void setOrcServOrdFab(Integer orcServOrdFab) {
        this.orcServOrdFab = orcServOrdFab;
    }

    public Integer getOrcServFabNum() {
        return orcServFabNum;
    }

    public void setOrcServFabNum(Integer orcServFabNum) {
        this.orcServFabNum = orcServFabNum;
    }
}