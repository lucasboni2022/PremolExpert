package com.premolexpert.api.dto;

public class PaisDTO {

    private Integer paisId;
    private String paisNom;
    private String paisSigla;

    public PaisDTO() {}


    public PaisDTO(Integer paisId, String paisNom, String paisSigla) {
        this.paisId = paisId;
        this.paisNom = paisNom;
        this.paisSigla = paisSigla;
    }



    public Integer getPaisId() { return paisId; }
    public void setPaisId(Integer paisId) { this.paisId = paisId; }

    public String getPaisNom() { return paisNom; }
    public void setPaisNom(String paisNom) { this.paisNom = paisNom; }

    public String getPaisSigla() {
        return paisSigla;
    }

    public void setPaisSigla(String paisSigla) {
        this.paisSigla = paisSigla;
    }
}
