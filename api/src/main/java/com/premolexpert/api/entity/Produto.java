package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbproduto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "tbproduto_prodid_seq", allocationSize = 1)
    @Column(name = "prodid", nullable = false)
    private Integer prodId;

    @Column(name = "proddsc", nullable = false, length = 100)
    private String prodDsc;

    @Column(name = "prodincpor", nullable = false)
    private Integer prodIncPor;

    @Column(name = "prodincem", nullable = false)
    private LocalDateTime prodIncEm;

    @Column(name = "prodaltpor")
    private Integer prodAltPor;

    @Column(name = "prodaltem")
    private LocalDateTime prodAltEm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;


    @Column(name = "prodsigla", length = 2)
    private String prodSigla;

    @Column(name = "prodsessao", length = 7)
    private String prodSessao;

    public Produto() {
    }

    // Getters e Setters

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdDsc() {
        return prodDsc;
    }

    public void setProdDsc(String prodDsc) {
        this.prodDsc = prodDsc;
    }

    public Integer getProdIncPor() {
        return prodIncPor;
    }

    public void setProdIncPor(Integer prodIncPor) {
        this.prodIncPor = prodIncPor;
    }

    public LocalDateTime getProdIncEm() {
        return prodIncEm;
    }

    public void setProdIncEm(LocalDateTime prodIncEm) {
        this.prodIncEm = prodIncEm;
    }

    public Integer getProdAltPor() {
        return prodAltPor;
    }

    public void setProdAltPor(Integer prodAltPor) {
        this.prodAltPor = prodAltPor;
    }

    public LocalDateTime getProdAltEm() {
        return prodAltEm;
    }

    public void setProdAltEm(LocalDateTime prodAltEm) {
        this.prodAltEm = prodAltEm;
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

    public String getProdSigla() {
        return prodSigla;
    }

    public void setProdSigla(String prodSigla) {
        this.prodSigla = prodSigla;
    }

    public String getProdSessao() {
        return prodSessao;
    }

    public void setProdSessao(String prodSessao) {
        this.prodSessao = prodSessao;
    }
}
