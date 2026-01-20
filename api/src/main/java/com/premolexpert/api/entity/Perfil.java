package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbperfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_seq")
    @SequenceGenerator(name = "perfil_seq", sequenceName = "tbperfil_perid_seq", allocationSize = 1)
    @Column(name = "perid", nullable = false)
    private Integer perId;

    @Column(name = "pernom", length = 100, nullable = false)
    private String perNom;

    @Column(name = "empid")
    private Integer empId;

    @Column(name = "perincpor")
    private Integer perIncPor;

    @Column(name = "perincem")
    private LocalDateTime perIncEm;

    @Column(name = "peraltpor")
    private Integer perAltPor;

    @Column(name = "peraltem")
    private LocalDateTime perAltEm;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNom() {
        return perNom;
    }

    public void setPerNom(String perNom) {
        this.perNom = perNom;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getPerIncPor() {
        return perIncPor;
    }

    public void setPerIncPor(Integer perIncPor) {
        this.perIncPor = perIncPor;
    }

    public LocalDateTime getPerIncEm() {
        return perIncEm;
    }

    public void setPerIncEm(LocalDateTime perIncEm) {
        this.perIncEm = perIncEm;
    }

    public Integer getPerAltPor() {
        return perAltPor;
    }

    public void setPerAltPor(Integer perAltPor) {
        this.perAltPor = perAltPor;
    }

    public LocalDateTime getPerAltEm() {
        return perAltEm;
    }

    public void setPerAltEm(LocalDateTime perAltEm) {
        this.perAltEm = perAltEm;
    }
}
