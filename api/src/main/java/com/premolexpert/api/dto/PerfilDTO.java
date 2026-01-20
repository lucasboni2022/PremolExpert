package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class PerfilDTO {

    private Integer perId;
    private String perNom;
    private Integer empId;
    private Integer perIncPor;
    private LocalDateTime perIncEm;
    private Integer perAltPor;
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
