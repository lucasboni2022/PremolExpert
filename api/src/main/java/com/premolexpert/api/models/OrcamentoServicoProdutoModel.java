package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentoservicoproduto")
public class OrcamentoServicoProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_servico_produto_seq")
    @SequenceGenerator(name = "orcamento_servico_produto_seq", sequenceName = "tborcamentoservicoproduto_orcservprodid_seq", allocationSize = 1)
    @Column(name = "orcservprodid", nullable = false)
    private Integer orcServProdId;

    @ManyToOne
    @JoinColumn(name = "prodid", referencedColumnName = "prodid", nullable = false)
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "uniid", referencedColumnName = "uniid", nullable = false)
    private UnidadeModel unidade;

    @Column(name = "orcservprodqtd", nullable = false)
    private Integer orcServProdQtd;

    @Column(name = "orcservprodvlrunit", nullable = false, precision = 18, scale = 2)
    private BigDecimal orcServProdVlrUnit;

    @Column(name = "orcservprodincpor", nullable = false)
    private Integer orcServProdIncPor;

    @Column(name = "orcservprodincem", nullable = false)
    private LocalDateTime orcServProdIncEm;

    @Column(name = "orcservprodaltpor")
    private Integer orcServProdAltPor;

    @Column(name = "orcservprodaltem")
    private LocalDateTime orcServProdAltEm;

    @Column(name = "orcservprodordfab")
    private Integer orcServProdOrdFab;

    @ManyToOne
    @JoinColumn(name = "orcservid", referencedColumnName = "orcservid")
    private OrcamentoServicoModel orcamentoServico;

    public OrcamentoServicoProdutoModel() {
    }

    // Getters e Setters

    public Integer getOrcServProdId() {
        return orcServProdId;
    }

    public void setOrcServProdId(Integer orcServProdId) {
        this.orcServProdId = orcServProdId;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }

    public Integer getOrcServProdQtd() {
        return orcServProdQtd;
    }

    public void setOrcServProdQtd(Integer orcServProdQtd) {
        this.orcServProdQtd = orcServProdQtd;
    }

    public BigDecimal getOrcServProdVlrUnit() {
        return orcServProdVlrUnit;
    }

    public void setOrcServProdVlrUnit(BigDecimal orcServProdVlrUnit) {
        this.orcServProdVlrUnit = orcServProdVlrUnit;
    }

    public Integer getOrcServProdIncPor() {
        return orcServProdIncPor;
    }

    public void setOrcServProdIncPor(Integer orcServProdIncPor) {
        this.orcServProdIncPor = orcServProdIncPor;
    }

    public LocalDateTime getOrcServProdIncEm() {
        return orcServProdIncEm;
    }

    public void setOrcServProdIncEm(LocalDateTime orcServProdIncEm) {
        this.orcServProdIncEm = orcServProdIncEm;
    }

    public Integer getOrcServProdAltPor() {
        return orcServProdAltPor;
    }

    public void setOrcServProdAltPor(Integer orcServProdAltPor) {
        this.orcServProdAltPor = orcServProdAltPor;
    }

    public LocalDateTime getOrcServProdAltEm() {
        return orcServProdAltEm;
    }

    public void setOrcServProdAltEm(LocalDateTime orcServProdAltEm) {
        this.orcServProdAltEm = orcServProdAltEm;
    }

    public Integer getOrcServProdOrdFab() {
        return orcServProdOrdFab;
    }

    public void setOrcServProdOrdFab(Integer orcServProdOrdFab) {
        this.orcServProdOrdFab = orcServProdOrdFab;
    }

    public OrcamentoServicoModel getOrcamentoServico() {
        return orcamentoServico;
    }

    public void setOrcamentoServico(OrcamentoServicoModel orcamentoServico) {
        this.orcamentoServico = orcamentoServico;
    }
}
