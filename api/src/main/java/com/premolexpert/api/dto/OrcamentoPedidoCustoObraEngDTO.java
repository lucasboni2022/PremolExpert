package com.premolexpert.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrcamentoPedidoCustoObraEngDTO {
    private Integer orcPedCustoObrEngId;
    private Integer orcPedCustoObrId;
    private Integer orcPedCustoObrEngQtdAFazer;
    private Integer orcPedCustoObrEngQtdLibParFabr;
    private Integer orcPedCustoObrEngLote;
    private Integer orcPedCustoObrEngIncPor;
    private LocalDateTime orcPedCustoObrEngIncEm;
    private Integer orcPedCustoObrEngAltPor;
    private LocalDateTime orcPedCustoObrEngAltEm;
}
