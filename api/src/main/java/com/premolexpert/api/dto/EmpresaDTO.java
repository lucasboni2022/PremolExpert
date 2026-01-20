package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class EmpresaDTO {

    private Integer empId;
    private String empNom;
    private Integer empIncPor;
    private LocalDateTime empIncEm;
    private Integer empAltPor;
    private LocalDateTime empAltEm;

    public EmpresaDTO() {}

    public EmpresaDTO(Integer empId, String empNom, Integer empIncPor, LocalDateTime empIncEm, Integer empAltPor, LocalDateTime empAltEm) {
        this.empId = empId;
        this.empNom = empNom;
        this.empIncPor = empIncPor;
        this.empIncEm = empIncEm;
        this.empAltPor = empAltPor;
        this.empAltEm = empAltEm;
    }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpNom() { return empNom; }
    public void setEmpNom(String empNom) { this.empNom = empNom; }

    public Integer getEmpIncPor() { return empIncPor; }
    public void setEmpIncPor(Integer empIncPor) { this.empIncPor = empIncPor; }

    public LocalDateTime getEmpIncEm() { return empIncEm; }
    public void setEmpIncEm(LocalDateTime empIncEm) { this.empIncEm = empIncEm; }

    public Integer getEmpAltPor() { return empAltPor; }
    public void setEmpAltPor(Integer empAltPor) { this.empAltPor = empAltPor; }

    public LocalDateTime getEmpAltEm() { return empAltEm; }
    public void setEmpAltEm(LocalDateTime empAltEm) { this.empAltEm = empAltEm; }
}
