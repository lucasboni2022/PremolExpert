package com.premolexpert.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidocustoobraeng")
@Data
public class OrcamentoPedidoCustoObraEng {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidocustoobraeng_seq")
    @SequenceGenerator(name = "orcamentopedidocustoobraeng_seq", sequenceName = "tborcamentopedidocustoobraeng_orcpedcustoobrengid_seq", allocationSize = 1)
    @Column(name = "orcpedcustoobrengid", nullable = false)
    private Integer orcPedCustoObrEngId;

    @ManyToOne
    @JoinColumn(name = "orcpedcustoobrid")
    private OrcamentoPedidoCustoObra orcPedCustoObr;

    @Column(name = "orcpedcustoobrengqtdafazer")
    private Integer orcPedCustoObrEngQtdAFazer;

    @Column(name = "orcpedcustoobrengqtdlibparfabr")
    private Integer orcPedCustoObrEngQtdLibParFabr;

    @Column(name = "orcpedcustoobrenglote")
    private Integer orcPedCustoObrEngLote;

    @Column(name = "orcpedcustoobrengincpor")
    private Integer orcPedCustoObrEngIncPor;

    @Column(name = "orcpedcustoobrengincem")
    private LocalDateTime orcPedCustoObrEngIncEm;

    @Column(name = "orcpedcustoobrengaltpor")
    private Integer orcPedCustoObrEngAltPor;

    @Column(name = "orcpedcustoobrengaltem")
    private LocalDateTime orcPedCustoObrEngAltEm;
}
