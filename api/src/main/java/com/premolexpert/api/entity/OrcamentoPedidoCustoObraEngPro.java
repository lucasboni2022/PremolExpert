package com.premolexpert.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidocustoobraengpro")
@Data
public class OrcamentoPedidoCustoObraEngPro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidocustoobraengpro_seq")
    @SequenceGenerator(name = "orcamentopedidocustoobraengpro_seq", sequenceName = "tborcamentopedidocustoobraengpro_orcpedcustoobrengproid_seq", allocationSize = 1)
    @Column(name = "orcpedcustoobrengproid", nullable = false)
    private Integer orcPedCustoObrEngProId;

    @ManyToOne
    @JoinColumn(name = "orcpedcustoobrengid")
    private OrcamentoPedidoCustoObraEng orcPedCustoObrEng;

    @Column(name = "orcpedcustoobrengproproduto")
    private String orcPedCustoObrEngProProduto;

    @Column(name = "orcpedcustoobrengproqtd")
    private Integer orcPedCustoObrEngProQtd;

    @Column(name = "orcpedcustoobrengproincpor")
    private Integer orcPedCustoObrEngProIncPor;

    @Column(name = "orcpedcustoobrengproincem")
    private LocalDateTime orcPedCustoObrEngProIncEm;

    @Column(name = "orcpedcustoobrengproaltpor")
    private Integer orcPedCustoObrEngProAltPor;

    @Column(name = "orcpedcustoobrengproaltem")
    private LocalDateTime orcPedCustoObrEngProAltEm;
}
