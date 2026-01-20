package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbempresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
    @SequenceGenerator(name = "empresa_seq", sequenceName = "tbempresa_empid_seq", allocationSize = 1)
    @Column(name = "empid", nullable = false)
    private Integer empId;

    @Column(name = "empnom", length = 200, nullable = false)
    private String empNom;

    @Column(name = "empincpor")
    private Integer empIncPor;

    @Column(name = "empincem")
    private LocalDateTime empIncEm;

    @Column(name = "empaltpor")
    private Integer empAltPor;

    @Column(name = "empaltem")
    private LocalDateTime empAltEm;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNom() {
        return empNom;
    }

    public void setEmpNom(String empNom) {
        this.empNom = empNom;
    }

    public Integer getEmpIncPor() {
        return empIncPor;
    }

    public void setEmpIncPor(Integer empIncPor) {
        this.empIncPor = empIncPor;
    }

    public LocalDateTime getEmpIncEm() {
        return empIncEm;
    }

    public void setEmpIncEm(LocalDateTime empIncEm) {
        this.empIncEm = empIncEm;
    }

    public Integer getEmpAltPor() {
        return empAltPor;
    }

    public void setEmpAltPor(Integer empAltPor) {
        this.empAltPor = empAltPor;
    }

    public LocalDateTime getEmpAltEm() {
        return empAltEm;
    }

    public void setEmpAltEm(LocalDateTime empAltEm) {
        this.empAltEm = empAltEm;
    }
}
