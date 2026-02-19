package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class EstadoDTO {

    private Integer estId;
    private String estNom;
    private String estSigla;
    private Integer empId;
    private Integer paisId;
    private String paisNom;
    private Integer estIncPor;
    private LocalDateTime estIncEm;
    private Integer estAltPor;
    private LocalDateTime estAltEm;

    public EstadoDTO() {}

    public EstadoDTO(Integer estId, String estNom, String estSigla, Integer empId, Integer paisId, String paisNom,
                     Integer estIncPor, LocalDateTime estIncEm, Integer estAltPor, LocalDateTime estAltEm) {
        this.estId = estId;
        this.estNom = estNom;
        this.estSigla = estSigla;
        this.empId = empId;
        this.paisId = paisId;
        this.paisNom = paisNom;
        this.estIncPor = estIncPor;
        this.estIncEm = estIncEm;
        this.estAltPor = estAltPor;
        this.estAltEm = estAltEm;
    }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public String getEstNom() { return estNom; }
    public void setEstNom(String estNom) { this.estNom = estNom; }

    public String getEstSigla() { return estSigla; }
    public void setEstSigla(String estSigla) { this.estSigla = estSigla; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public Integer getPaisId() { return paisId; }
    public void setPaisId(Integer paisId) { this.paisId = paisId; }

    public String getPaisNom() { return paisNom; }
    public void setPaisNom(String paisNom) { this.paisNom = paisNom; }

    public Integer getEstIncPor() { return estIncPor; }
    public void setEstIncPor(Integer estIncPor) { this.estIncPor = estIncPor; }

    public LocalDateTime getEstIncEm() { return estIncEm; }
    public void setEstIncEm(LocalDateTime estIncEm) { this.estIncEm = estIncEm; }

    public Integer getEstAltPor() { return estAltPor; }
    public void setEstAltPor(Integer estAltPor) { this.estAltPor = estAltPor; }

    public LocalDateTime getEstAltEm() { return estAltEm; }
    public void setEstAltEm(LocalDateTime estAltEm) { this.estAltEm = estAltEm; }
}
