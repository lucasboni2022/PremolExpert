package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "tborcamentopedidocustoobra",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"orcpedid", "sercustoid"})
        }
)
public class OrcamentoPedidoCustoObra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orc_ped_custo_obra_seq")
    @SequenceGenerator(
            name = "orc_ped_custo_obra_seq",
            sequenceName = "tborcamentopedidocustoobra_orcpedcustoobrid_seq",
            allocationSize = 1
    )
    @Column(name = "orcpedcustoobrid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orcpedid", nullable = false)
    private OrcamentoPedido orcamentoPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sercustoid", nullable = false)
    private ServicoCusto servicoCusto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uniid", nullable = false)
    private Unidade unidade;

    @Column(name = "orcpedcustoobrqtd")
    private Integer quantidade;

    @Column(name = "orcpedcustoobrVlrUnit", precision = 18, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "orcpedcustoobrpron")
    private Integer prazo;

    @Column(name = "orcpedcustoobrfaze")
    private Integer fase;

    @Column(name = "orcpedcustoobrsitua")
    private Integer situacao;

    @Column(name = "orcpedcustoobrtipo", length = 50)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;


    @Column(name = "orcpedcustoobrincpor")
    private Integer incluidoPor;

    @Column(name = "orcpedcustoobrincem")
    private LocalDateTime incluidoEm;

    @Column(name = "orcpedcustoobraltpor")
    private Integer alteradoPor;

    @Column(name = "orcpedcustoobraltem")
    private LocalDateTime alteradoEm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrcamentoPedido getOrcamentoPedido() {
        return orcamentoPedido;
    }

    public void setOrcamentoPedido(OrcamentoPedido orcamentoPedido) {
        this.orcamentoPedido = orcamentoPedido;
    }

    public Integer getOrcPedId() {
        return orcamentoPedido != null ? orcamentoPedido.getOrcPedId() : null;
    }

    public ServicoCusto getServicoCusto() {
        return servicoCusto;
    }

    public void setServicoCusto(ServicoCusto servicoCusto) {
        this.servicoCusto = servicoCusto;
    }

    public Integer getSerCustoId() {
        return servicoCusto != null ? servicoCusto.getSerCustoId() : null;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Integer getUniId() {
        return unidade != null ? unidade.getUniId() : null;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpId() {
        return empresa != null ? empresa.getEmpId() : null;
    }

    public Integer getIncluidoPor() {
        return incluidoPor;
    }

    public void setIncluidoPor(Integer incluidoPor) {
        this.incluidoPor = incluidoPor;
    }

    public LocalDateTime getIncluidoEm() {
        return incluidoEm;
    }

    public void setIncluidoEm(LocalDateTime incluidoEm) {
        this.incluidoEm = incluidoEm;
    }

    public Integer getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Integer alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public LocalDateTime getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(LocalDateTime alteradoEm) {
        this.alteradoEm = alteradoEm;
    }
}
