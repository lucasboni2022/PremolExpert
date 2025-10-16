package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbpessoa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "tbpessoa_pesid_seq", allocationSize = 1)
    @Column(name = "pesid", nullable = false)
    private Integer pesId;

    @Column(name = "pesnom", length = 100, nullable = false)
    private String pesNom;

    @Column(name = "pescpf")
    private Long pesCpf;

    @Column(name = "pescnpj")
    private Long pesCnpj;

    @Column(name = "pesemail", length = 100)
    private String pesEmail;

    @Column(name = "pestelpesddd")
    private Integer pesTelPesDDD;

    @Column(name = "pestelpes")
    private Integer pesTelPes;

    @Column(name = "pestelcomddd")
    private Integer pesTelComDDD;

    @Column(name = "pestelcom")
    private Integer pesTelCom;

    @Column(name = "pescelpesddd")
    private Integer pesCelPesDDD;

    @Column(name = "pescelpes")
    private Integer pesCelPes;

    @Column(name = "pescelcomddd")
    private Integer pesCelComDDD;

    @Column(name = "pescelcompes")
    private Integer pesCelComPes;

    @Column(name = "pesend", length = 200)
    private String pesEnd;

    @Column(name = "munid")
    private Integer munId;

    @Column(name = "empid", nullable = false)
    private Integer empId;

    @Column(name = "pesfisjur", nullable = false)
    private Integer pesFisJur;

    @Column(name = "pesincpor", nullable = false)
    private Integer pesIncPor;

    @Column(name = "pesincem", nullable = false)
    private LocalDate pesIncEm;

    @Column(name = "pesaltpor")
    private Integer pesAltPor;

    @Column(name = "pesaltem")
    private LocalDate pesAltEm;

    // Getters e Setters
    public Integer getPesId() { return pesId; }
    public void setPesId(Integer pesId) { this.pesId = pesId; }

    public String getPesNom() { return pesNom; }
    public void setPesNom(String pesNom) { this.pesNom = pesNom; }

    public Long getPesCpf() { return pesCpf; }
    public void setPesCpf(Long pesCpf) { this.pesCpf = pesCpf; }

    public Long getPesCnpj() { return pesCnpj; }
    public void setPesCnpj(Long pesCnpj) { this.pesCnpj = pesCnpj; }

    public String getPesEmail() { return pesEmail; }
    public void setPesEmail(String pesEmail) { this.pesEmail = pesEmail; }

    public Integer getPesTelPesDDD() { return pesTelPesDDD; }
    public void setPesTelPesDDD(Integer pesTelPesDDD) { this.pesTelPesDDD = pesTelPesDDD; }

    public Integer getPesTelPes() { return pesTelPes; }
    public void setPesTelPes(Integer pesTelPes) { this.pesTelPes = pesTelPes; }

    public Integer getPesTelComDDD() { return pesTelComDDD; }
    public void setPesTelComDDD(Integer pesTelComDDD) { this.pesTelComDDD = pesTelComDDD; }

    public Integer getPesTelCom() { return pesTelCom; }
    public void setPesTelCom(Integer pesTelCom) { this.pesTelCom = pesTelCom; }

    public Integer getPesCelPesDDD() { return pesCelPesDDD; }
    public void setPesCelPesDDD(Integer pesCelPesDDD) { this.pesCelPesDDD = pesCelPesDDD; }

    public Integer getPesCelPes() { return pesCelPes; }
    public void setPesCelPes(Integer pesCelPes) { this.pesCelPes = pesCelPes; }

    public Integer getPesCelComDDD() { return pesCelComDDD; }
    public void setPesCelComDDD(Integer pesCelComDDD) { this.pesCelComDDD = pesCelComDDD; }

    public Integer getPesCelComPes() { return pesCelComPes; }
    public void setPesCelComPes(Integer pesCelComPes) { this.pesCelComPes = pesCelComPes; }

    public String getPesEnd() { return pesEnd; }
    public void setPesEnd(String pesEnd) { this.pesEnd = pesEnd; }

    public Integer getMunId() { return munId; }
    public void setMunId(Integer munId) { this.munId = munId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getPesFisJur() { return pesFisJur; }
    public void setPesFisJur(Integer pesFisJur) { this.pesFisJur = pesFisJur; }

    public Integer getPesIncPor() { return pesIncPor; }
    public void setPesIncPor(Integer pesIncPor) { this.pesIncPor = pesIncPor; }

    public LocalDate getPesIncEm() { return pesIncEm; }
    public void setPesIncEm(LocalDate pesIncEm) { this.pesIncEm = pesIncEm; }

    public Integer getPesAltPor() { return pesAltPor; }
    public void setPesAltPor(Integer pesAltPor) { this.pesAltPor = pesAltPor; }

    public LocalDate getPesAltEm() { return pesAltEm; }
    public void setPesAltEm(LocalDate pesAltEm) { this.pesAltEm = pesAltEm; }
}
