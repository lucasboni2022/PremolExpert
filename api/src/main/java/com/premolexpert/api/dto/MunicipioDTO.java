package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class MunicipioDTO {
    private Integer munId;
    private String munNom;
    private Integer estId;
    private Integer empId;
    private Integer munMunOrigId;
    private Boolean munAtivo;
    private Integer munIncPor;
    private LocalDateTime munIncEm;
    private Integer munAltPor;
    private LocalDateTime munAltEm;

    public MunicipioDTO() {
    }

    public MunicipioDTO(Integer munId, String munNom, Integer estId, Integer empId, Integer munMunOrigId, Boolean munAtivo, Integer munIncPor, LocalDateTime munIncEm, Integer munAltPor, LocalDateTime munAltEm) {
        this.munId = munId;
        this.munNom = munNom;
        this.estId = estId;
        this.empId = empId;
        this.munMunOrigId = munMunOrigId;
        this.munAtivo = munAtivo;
        this.munIncPor = munIncPor;
        this.munIncEm = munIncEm;
        this.munAltPor = munAltPor;
        this.munAltEm = munAltEm;
    }

    public Integer getMunId() {
        return munId;
    }

    public void setMunId(Integer munId) {
        this.munId = munId;
    }

    public String getMunNom() {
        return munNom;
    }

    public void setMunNom(String munNom) {
        this.munNom = munNom;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMunMunOrigId() {
        return munMunOrigId;
    }

    public void setMunMunOrigId(Integer munMunOrigId) {
        this.munMunOrigId = munMunOrigId;
    }

    public Boolean getMunAtivo() {
        return munAtivo;
    }

    public void setMunAtivo(Boolean munAtivo) {
        this.munAtivo = munAtivo;
    }

    public Integer getMunIncPor() {
        return munIncPor;
    }

    public void setMunIncPor(Integer munIncPor) {
        this.munIncPor = munIncPor;
    }

    public LocalDateTime getMunIncEm() {
        return munIncEm;
    }

    public void setMunIncEm(LocalDateTime munIncEm) {
        this.munIncEm = munIncEm;
    }

    public Integer getMunAltPor() {
        return munAltPor;
    }

    public void setMunAltPor(Integer munAltPor) {
        this.munAltPor = munAltPor;
    }

    public LocalDateTime getMunAltEm() {
        return munAltEm;
    }

    public void setMunAltEm(LocalDateTime munAltEm) {
        this.munAltEm = munAltEm;
    }
}
