package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbpermissaoacesso",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"perid", "telid", "acaid", "usuid"})
                }
        )
public class PermissaoAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoacesso_seq")
    @SequenceGenerator(name = "permissaoacesso_seq", sequenceName = "tbpermissaoacesso_permaceid_seq", allocationSize = 1)
    @Column(name = "permaceid", nullable = false)
    private Integer permAceId;


    @ManyToOne
    @JoinColumn(name = "perid")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "telid")
    private Tela tela;

    @ManyToOne
    @JoinColumn(name = "acaid")
    private Acao acao;

    @ManyToOne
    @JoinColumn(name = "usuid")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "permacesta")
    private Integer permAceSta;

    @Column(name = "permaceincpor")
    private Integer permAceIncPor;

    @Column(name = "permaceincem")
    private LocalDateTime permAceIncEm;

    @Column(name = "permacealtpor")
    private Integer permAceAltPor;

    @Column(name = "permacealtem")
    private LocalDateTime permAceAltEm;

    public Integer getPermAceId() {
        return permAceId;
    }

    public void setPermAceId(Integer permAceId) {
        this.permAceId = permAceId;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getPermAceSta() {
        return permAceSta;
    }

    public void setPermAceSta(Integer permAceSta) {
        this.permAceSta = permAceSta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpId() {
        return empresa != null ? empresa.getEmpId() : null;
    }

    public Integer getPermAceIncPor() {
        return permAceIncPor;
    }

    public void setPermAceIncPor(Integer permAceIncPor) {
        this.permAceIncPor = permAceIncPor;
    }

    public LocalDateTime getPermAceIncEm() {
        return permAceIncEm;
    }

    public void setPermAceIncEm(LocalDateTime permAceIncEm) {
        this.permAceIncEm = permAceIncEm;
    }

    public Integer getPermAceAltPor() {
        return permAceAltPor;
    }

    public void setPermAceAltPor(Integer permAceAltPor) {
        this.permAceAltPor = permAceAltPor;
    }

    public LocalDateTime getPermAceAltEm() {
        return permAceAltEm;
    }

    public void setPermAceAltEm(LocalDateTime permAceAltEm) {
        this.permAceAltEm = permAceAltEm;
    }
}









