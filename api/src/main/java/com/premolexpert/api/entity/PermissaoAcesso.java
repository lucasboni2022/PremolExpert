package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbpermissaoacesso")
public class PermissaoAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoacesso_seq")
    @SequenceGenerator(name = "permissaoacesso_seq", sequenceName = "tbpermissaoacesso_permaceid_seq", allocationSize = 1)
    @Column(name = "permaceid", nullable = false)
    private Integer permAceId;

    @Column(name = "perid")
    private Integer perId;

    @ManyToOne
    @JoinColumn(name = "perid", insertable = false, updatable = false)
    private Perfil perfil;

    @Column(name = "telid")
    private Integer telId;

    @ManyToOne
    @JoinColumn(name = "telid", insertable = false, updatable = false)
    private Tela tela;

    @Column(name = "acaid")
    private Integer acaId;

    @ManyToOne
    @JoinColumn(name = "acaid", insertable = false, updatable = false)
    private Acao acao;

    @Column(name = "usuid")
    private Integer usuId;

    @ManyToOne
    @JoinColumn(name = "usuid", insertable = false, updatable = false)
    private Usuario usuario;

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

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Integer getAcaId() {
        return acaId;
    }

    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
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









