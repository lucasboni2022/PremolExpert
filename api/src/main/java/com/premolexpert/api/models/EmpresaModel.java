package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbempresa")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
    @SequenceGenerator(name = "empresa_seq", sequenceName = "tbempresa_empid_seq", allocationSize = 1)
    @Column(name = "empid", nullable = false)
    private Integer empId;

    @Column(name = "empnom", nullable = true, length = 150)
    private String empNom;

    @Column(name = "empincpor", nullable = false)
    private Integer empIncPor;

    @Column(name = "empincem", nullable = false)
    private LocalDate empIncEm;

    @Column(name = "empaltpor")
    private Integer empAltPor;

    @Column(name = "empaltem")
    private LocalDate empAltEm;

    public EmpresaModel() {
    }

    // Getters e Setters

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

    public LocalDate getEmpIncEm() {
        return empIncEm;
    }

    public void setEmpIncEm(LocalDate empIncEm) {
        this.empIncEm = empIncEm;
    }

    public Integer getEmpAltPor() {
        return empAltPor;
    }

    public void setEmpAltPor(Integer empAltPor) {
        this.empAltPor = empAltPor;
    }

    public LocalDate getEmpAltEm() {
        return empAltEm;
    }

    public void setEmpAltEm(LocalDate empAltEm) {
        this.empAltEm = empAltEm;
    }
}
