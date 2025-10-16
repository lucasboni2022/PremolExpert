package com.premolexpert.api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbservico")
public class ServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_seq")
    @SequenceGenerator(name = "servico_seq", sequenceName = "tbservico_servid_seq", allocationSize = 1)
    @Column(name = "servid", nullable = false)
    private Integer servId;

    @Column(name = "servdesc", nullable = false, length = 100)
    private String servDesc;

    @Column(name = "servincpor", nullable = false)
    private Integer servIncPor;

    @Column(name = "servincem", nullable = false)
    private LocalDate servIncEm;

    @Column(name = "servaltpor")
    private Integer servAltPor;

    @Column(name = "servaltem")
    private LocalDate servAltEm;

    public ServicoModel() {
    }

    // Este construtor pode ser útil para criar instâncias apenas com o ID
    public ServicoModel(Integer servId) {
        this.servId = servId;
    }

    // Getters e Setters

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer servId) {
        this.servId = servId;
    }

    public String getServDesc() {
        return servDesc;
    }

    public void setServDesc(String servDesc) {
        this.servDesc = servDesc;
    }

    public Integer getServIncPor() {
        return servIncPor;
    }

    public void setServIncPor(Integer servIncPor) {
        this.servIncPor = servIncPor;
    }

    public LocalDate getServIncEm() {
        return servIncEm;
    }

    public void setServIncEm(LocalDate servIncEm) {
        this.servIncEm = servIncEm;
    }

    public Integer getServAltPor() {
        return servAltPor;
    }

    public void setServAltPor(Integer servAltPor) {
        this.servAltPor = servAltPor;
    }

    public LocalDate getServAltEm() {
        return servAltEm;
    }

    public void setServAltEm(LocalDate servAltEm) {
        this.servAltEm = servAltEm;
    }
}