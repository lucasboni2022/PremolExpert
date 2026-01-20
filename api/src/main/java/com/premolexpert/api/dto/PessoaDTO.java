package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class PessoaDTO {
    private Integer pesId;
    private String pesNom;
    private String pesCpf;
    private String pesCnpj;
    private String pesEmail;
    private String pesEnd;
    private Integer munId;
    private Integer empId;
    private String pesFisJur;
    private String pesTelPesDDD;
    private String pesTelPes;
    private String pesTelComDDD;
    private String pesTelCom;
    private String pesCelPesDDD;
    private String pesCelPes;
    private String pesCelComDDD;
    private String pesCelComPes;
    private Integer pesIncPor;
    private LocalDateTime pesIncEm;
    private Integer pesAltPor;
    private LocalDateTime pesAltEm;

    public PessoaDTO() {
    }

    public Integer getPesId() { return pesId; }
    public void setPesId(Integer pesId) { this.pesId = pesId; }

    public String getPesNom() { return pesNom; }
    public void setPesNom(String pesNom) { this.pesNom = pesNom; }

    public String getPesCpf() { return pesCpf; }
    public void setPesCpf(String pesCpf) { this.pesCpf = pesCpf; }

    public String getPesCnpj() { return pesCnpj; }
    public void setPesCnpj(String pesCnpj) { this.pesCnpj = pesCnpj; }

    public String getPesEmail() { return pesEmail; }
    public void setPesEmail(String pesEmail) { this.pesEmail = pesEmail; }

    public String getPesEnd() { return pesEnd; }
    public void setPesEnd(String pesEnd) { this.pesEnd = pesEnd; }

    public Integer getMunId() { return munId; }
    public void setMunId(Integer munId) { this.munId = munId; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getPesFisJur() { return pesFisJur; }
    public void setPesFisJur(String pesFisJur) { this.pesFisJur = pesFisJur; }

    public String getPesTelPesDDD() { return pesTelPesDDD; }
    public void setPesTelPesDDD(String pesTelPesDDD) { this.pesTelPesDDD = pesTelPesDDD; }

    public String getPesTelPes() { return pesTelPes; }
    public void setPesTelPes(String pesTelPes) { this.pesTelPes = pesTelPes; }

    public String getPesTelComDDD() { return pesTelComDDD; }
    public void setPesTelComDDD(String pesTelComDDD) { this.pesTelComDDD = pesTelComDDD; }

    public String getPesTelCom() { return pesTelCom; }
    public void setPesTelCom(String pesTelCom) { this.pesTelCom = pesTelCom; }

    public String getPesCelPesDDD() { return pesCelPesDDD; }
    public void setPesCelPesDDD(String pesCelPesDDD) { this.pesCelPesDDD = pesCelPesDDD; }

    public String getPesCelPes() { return pesCelPes; }
    public void setPesCelPes(String pesCelPes) { this.pesCelPes = pesCelPes; }

    public String getPesCelComDDD() { return pesCelComDDD; }
    public void setPesCelComDDD(String pesCelComDDD) { this.pesCelComDDD = pesCelComDDD; }

    public String getPesCelComPes() { return pesCelComPes; }
    public void setPesCelComPes(String pesCelComPes) { this.pesCelComPes = pesCelComPes; }

    public Integer getPesIncPor() { return pesIncPor; }
    public void setPesIncPor(Integer pesIncPor) { this.pesIncPor = pesIncPor; }

    public LocalDateTime getPesIncEm() { return pesIncEm; }
    public void setPesIncEm(LocalDateTime pesIncEm) { this.pesIncEm = pesIncEm; }

    public Integer getPesAltPor() { return pesAltPor; }
    public void setPesAltPor(Integer pesAltPor) { this.pesAltPor = pesAltPor; }

    public LocalDateTime getPesAltEm() { return pesAltEm; }
    public void setPesAltEm(LocalDateTime pesAltEm) { this.pesAltEm = pesAltEm; }
}
