package com.premolexpert.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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
}
