package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentoservicoprodutofabpro")
public class OrcamentoServicoProdutoFabProModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_servico_produto_fab_pro_seq")
    @SequenceGenerator(name = "orcamento_servico_produto_fab_pro_seq", sequenceName = "tborcamentoservicoprodutofabpro_orcservprodfaprobid_seq", allocationSize = 1)
    @Column(name = "orcservprodfaprobid", nullable = false)
    private Integer orcServProdFabProId;

    @ManyToOne
    @JoinColumn(name = "orcservprodfabid", referencedColumnName = "orcservprodfabid", nullable = false)
    private OrcamentoServicoProdutoFabModel orcamentoServicoProdutoFab;

    @Column(name = "orcservprodfabprodta", nullable = false)
    private Integer orcServProdFabProDta;

    @Column(name = "orcservprodfabproincpor", nullable = false)
    private Integer orcServProdFabProIncPor;

    @Column(name = "orcservprodfabproincem", nullable = false)
    private LocalDateTime orcServProdFabProIncEm;

    @Column(name = "orcservprodfabproaltpor")
    private Integer orcServProdFabProAltPor;

    @Column(name = "orcservprodfabproaltem")
    private LocalDateTime orcServProdFabProAltEm;

    public OrcamentoServicoProdutoFabProModel() {
    }

    // Getters e Setters

    public Integer getOrcServProdFabProId() {
        return orcServProdFabProId;
    }

    public void setOrcServProdFabProId(Integer orcServProdFabProId) {
        this.orcServProdFabProId = orcServProdFabProId;
    }

    public OrcamentoServicoProdutoFabModel getOrcamentoServicoProdutoFab() {
        return orcamentoServicoProdutoFab;
    }

    public void setOrcamentoServicoProdutoFab(OrcamentoServicoProdutoFabModel orcamentoServicoProdutoFab) {
        this.orcamentoServicoProdutoFab = orcamentoServicoProdutoFab;
    }

    public Integer getOrcServProdFabProDta() {
        return orcServProdFabProDta;
    }

    public void setOrcServProdFabProDta(Integer orcServProdFabProDta) {
        this.orcServProdFabProDta = orcServProdFabProDta;
    }

    public Integer getOrcServProdFabProIncPor() {
        return orcServProdFabProIncPor;
    }

    public void setOrcServProdFabProIncPor(Integer orcServProdFabProIncPor) {
        this.orcServProdFabProIncPor = orcServProdFabProIncPor;
    }

    public LocalDateTime getOrcServProdFabProIncEm() {
        return orcServProdFabProIncEm;
    }

    public void setOrcServProdFabProIncEm(LocalDateTime orcServProdFabProIncEm) {
        this.orcServProdFabProIncEm = orcServProdFabProIncEm;
    }

    public Integer getOrcServProdFabProAltPor() {
        return orcServProdFabProAltPor;
    }

    public void setOrcServProdFabProAltPor(Integer orcServProdFabProAltPor) {
        this.orcServProdFabProAltPor = orcServProdFabProAltPor;
    }

    public LocalDateTime getOrcServProdFabProAltEm() {
        return orcServProdFabProAltEm;
    }

    public void setOrcServProdFabProAltEm(LocalDateTime orcServProdFabProAltEm) {
        this.orcServProdFabProAltEm = orcServProdFabProAltEm;
    }
}
