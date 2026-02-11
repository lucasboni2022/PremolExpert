package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbpessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "tbpessoa_pesid_seq", allocationSize = 1)
    @Column(name = "pesid", nullable = false)
    private Integer pesId;

    @Column(name = "pesnom", length = 200, nullable = false)
    private String pesNom;

    @Column(name = "pescpf", length = 14)
    private String pesCpf;

    @Column(name = "pescnpj", length = 20)
    private String pesCnpj;

    @Column(name = "pesemail", length = 100)
    private String pesEmail;

    @Column(name = "pesend", length = 255)
    private String pesEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "munid", nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "pesfisjur", length = 10)
    private String pesFisJur;

    @Column(name = "pestelpesddd", length = 5)
    private String pesTelPesDDD;

    @Column(name = "pestelpes", length = 20)
    private String pesTelPes;

    @Column(name = "pestelcomddd", length = 5)
    private String pesTelComDDD;

    @Column(name = "pestelcom", length = 20)
    private String pesTelCom;

    @Column(name = "pescelpesddd", length = 5)
    private String pesCelPesDDD;

    @Column(name = "pescelpes", length = 20)
    private String pesCelPes;

    @Column(name = "pescelcomddd", length = 5)
    private String pesCelComDDD;

    @Column(name = "pescelcompes", length = 20)
    private String pesCelComPes;

    @Column(name = "pesincpor")
    private Integer pesIncPor;

    @Column(name = "pesincem")
    private LocalDateTime pesIncEm;

    @Column(name = "pesaltpor")
    private Integer pesAltPor;

    @Column(name = "pesaltem")
    private LocalDateTime pesAltEm;

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNom() {
        return pesNom;
    }

    public void setPesNom(String pesNom) {
        this.pesNom = pesNom;
    }

    public String getPesCpf() {
        return pesCpf;
    }

    public void setPesCpf(String pesCpf) {
        this.pesCpf = pesCpf;
    }

    public String getPesCnpj() {
        return pesCnpj;
    }

    public void setPesCnpj(String pesCnpj) {
        this.pesCnpj = pesCnpj;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public String getPesEnd() {
        return pesEnd;
    }

    public void setPesEnd(String pesEnd) {
        this.pesEnd = pesEnd;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPesFisJur() {
        return pesFisJur;
    }

    public void setPesFisJur(String pesFisJur) {
        this.pesFisJur = pesFisJur;
    }

    public String getPesTelPesDDD() {
        return pesTelPesDDD;
    }

    public void setPesTelPesDDD(String pesTelPesDDD) {
        this.pesTelPesDDD = pesTelPesDDD;
    }

    public String getPesTelPes() {
        return pesTelPes;
    }

    public void setPesTelPes(String pesTelPes) {
        this.pesTelPes = pesTelPes;
    }

    public String getPesTelComDDD() {
        return pesTelComDDD;
    }

    public void setPesTelComDDD(String pesTelComDDD) {
        this.pesTelComDDD = pesTelComDDD;
    }

    public String getPesTelCom() {
        return pesTelCom;
    }

    public void setPesTelCom(String pesTelCom) {
        this.pesTelCom = pesTelCom;
    }

    public String getPesCelPesDDD() {
        return pesCelPesDDD;
    }

    public void setPesCelPesDDD(String pesCelPesDDD) {
        this.pesCelPesDDD = pesCelPesDDD;
    }

    public String getPesCelPes() {
        return pesCelPes;
    }

    public void setPesCelPes(String pesCelPes) {
        this.pesCelPes = pesCelPes;
    }

    public String getPesCelComDDD() {
        return pesCelComDDD;
    }

    public void setPesCelComDDD(String pesCelComDDD) {
        this.pesCelComDDD = pesCelComDDD;
    }

    public String getPesCelComPes() {
        return pesCelComPes;
    }

    public void setPesCelComPes(String pesCelComPes) {
        this.pesCelComPes = pesCelComPes;
    }

    public Integer getPesIncPor() {
        return pesIncPor;
    }

    public void setPesIncPor(Integer pesIncPor) {
        this.pesIncPor = pesIncPor;
    }

    public LocalDateTime getPesIncEm() {
        return pesIncEm;
    }

    public void setPesIncEm(LocalDateTime pesIncEm) {
        this.pesIncEm = pesIncEm;
    }

    public Integer getPesAltPor() {
        return pesAltPor;
    }

    public void setPesAltPor(Integer pesAltPor) {
        this.pesAltPor = pesAltPor;
    }

    public LocalDateTime getPesAltEm() {
        return pesAltEm;
    }

    public void setPesAltEm(LocalDateTime pesAltEm) {
        this.pesAltEm = pesAltEm;
    }
}
