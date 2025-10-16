package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentoservicoprodutofab")
public class OrcamentoServicoProdutoFabModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_servico_produto_fab_seq")
    @SequenceGenerator(name = "orcamento_servico_produto_fab_seq", sequenceName = "tborcamentoservicoprodutofab_orcservprodfabid_seq", allocationSize = 1)
    @Column(name = "orcservprodfabid", nullable = false)
    private Integer orcServProdFabId;

    @ManyToOne
    @JoinColumn(name = "orcservprodid", referencedColumnName = "orcservprodid", nullable = false)
    private OrcamentoServicoProdutoModel orcamentoServicoProduto;

    @Column(name = "orcservprodfabsetor", nullable = false)
    private Integer orcServProdFabSetor;

    @Column(name = "orcprodfabincpor", nullable = false)
    private Integer orcProdFabIncPor;

    @Column(name = "orcprodfabincem", nullable = false)
    private LocalDateTime orcProdFabIncEm;

    @Column(name = "orcprodfabaltpor")
    private Integer orcProdFabAltPor;

    @Column(name = "orcprodfabaltem")
    private LocalDateTime orcProdFabAltEm;

    @Column(name = "orcprodfabsigla", length = 5)
    private String orcProdFabSigla;

    @Column(name = "orcservprodfabetap")
    private Integer orcServProdFabEtap;

    public OrcamentoServicoProdutoFabModel() {
    }

    // Getters e Setters

    public Integer getOrcServProdFabId() {
        return orcServProdFabId;
    }

    public void setOrcServProdFabId(Integer orcServProdFabId) {
        this.orcServProdFabId = orcServProdFabId;
    }

    public OrcamentoServicoProdutoModel getOrcamentoServicoProduto() {
        return orcamentoServicoProduto;
    }

    public void setOrcamentoServicoProduto(OrcamentoServicoProdutoModel orcamentoServicoProduto) {
        this.orcamentoServicoProduto = orcamentoServicoProduto;
    }

    public Integer getOrcServProdFabSetor() {
        return orcServProdFabSetor;
    }

    public void setOrcServProdFabSetor(Integer orcServProdFabSetor) {
        this.orcServProdFabSetor = orcServProdFabSetor;
    }

    public Integer getOrcProdFabIncPor() {
        return orcProdFabIncPor;
    }

    public void setOrcProdFabIncPor(Integer orcProdFabIncPor) {
        this.orcProdFabIncPor = orcProdFabIncPor;
    }

    public LocalDateTime getOrcProdFabIncEm() {
        return orcProdFabIncEm;
    }

    public void setOrcProdFabIncEm(LocalDateTime orcProdFabIncEm) {
        this.orcProdFabIncEm = orcProdFabIncEm;
    }

    public Integer getOrcProdFabAltPor() {
        return orcProdFabAltPor;
    }

    public void setOrcProdFabAltPor(Integer orcProdFabAltPor) {
        this.orcProdFabAltPor = orcProdFabAltPor;
    }

    public LocalDateTime getOrcProdFabAltEm() {
        return orcProdFabAltEm;
    }

    public void setOrcProdFabAltEm(LocalDateTime orcProdFabAltEm) {
        this.orcProdFabAltEm = orcProdFabAltEm;
    }

    public String getOrcProdFabSigla() {
        return orcProdFabSigla;
    }

    public void setOrcProdFabSigla(String orcProdFabSigla) {
        this.orcProdFabSigla = orcProdFabSigla;
    }

    public Integer getOrcServProdFabEtap() {
        return orcServProdFabEtap;
    }

    public void setOrcServProdFabEtap(Integer orcServProdFabEtap) {
        this.orcServProdFabEtap = orcServProdFabEtap;
    }
}
