package com.premolexpert.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrcamentoPedidoCustoObraEngProDTO {
    private Integer orcPedCustoObrEngProId;
    private Integer orcPedCustoObrEngId;
    private String orcPedCustoObrEngProProduto;
    private Integer orcPedCustoObrEngProQtd;
    private Integer orcPedCustoObrEngProIncPor;
    private LocalDateTime orcPedCustoObrEngProIncEm;
    private Integer orcPedCustoObrEngProAltPor;
    private LocalDateTime orcPedCustoObrEngProAltEm;
}
