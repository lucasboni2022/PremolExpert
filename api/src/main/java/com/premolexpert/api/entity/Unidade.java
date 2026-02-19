package com.premolexpert.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbunidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_seq")
    @SequenceGenerator(name = "unidade_seq", sequenceName = "tbunidade_uniid_seq", allocationSize = 1)
    @Column(name = "uniid", nullable = false)
    private Integer uniId;

    @Column(name = "uninom", length = 100)
    private String uniNom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    public Integer getUniId() {
        return uniId;
    }

    public void setUniId(Integer uniId) {
        this.uniId = uniId;
    }

    public String getUniNom() {
        return uniNom;
    }

    public void setUniNom(String uniNom) {
        this.uniNom = uniNom;
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
}
