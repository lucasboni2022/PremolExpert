-- =========================
-- SEQUENCES
-- =========================
create sequence tbacao_acaid_seq start with 1 increment by 1;
create sequence tbempresa_empid_seq start with 1 increment by 1;
create sequence tbestado_estid_seq start with 1 increment by 1;
create sequence tbmunicipio_munid_seq start with 1 increment by 1;
create sequence tborcamentopedido_orcpedid_seq start with 1 increment by 1;
create sequence tborcamentopedidocustoobra_orcpedcustoobrid_seq start with 1 increment by 1;
create sequence tborcamentopedidocustoobraeng_orcpedcustoobrengid_seq start with 1 increment by 1;
create sequence tborcamentopedidocustoobraengpro_orcpedcustoobrengproid_seq start with 1 increment by 1;
create sequence tborcamentopedidohistorico_orcpedhistid_seq start with 1 increment by 1;
create sequence tbpais_paisid_seq start with 1 increment by 1;
create sequence tbperfil_perid_seq start with 1 increment by 1;
create sequence tbpermissaoacesso_permaceid_seq start with 1 increment by 1;
create sequence tbpessoa_pesid_seq start with 1 increment by 1;
create sequence tbproduto_prodid_seq start with 1 increment by 1;
create sequence tbservico_serid_seq start with 1 increment by 1;
create sequence tbservicocusto_sercustoid_seq start with 1 increment by 1;
create sequence tbtela_telid_seq start with 1 increment by 1;
create sequence tbunidade_uniid_seq start with 1 increment by 1;

-- =========================
-- TABELAS BASE
-- =========================
create table tbpais (
    paisid integer not null,
    paisnom varchar(255) not null,
    paissigla varchar(255) not null,
    paisaltpor integer,
    paisincpor integer,
    paisaltem timestamp(6),
    paisincem timestamp(6),
    primary key (paisid)
);

create table tbempresa (
    empid integer not null,
    empnom varchar(200) not null,
    empaltpor integer,
    empincpor integer,
    empaltem timestamp(6),
    empincem timestamp(6),
    primary key (empid)
);

create table tbestado (
    estid integer not null,
    estnom varchar(100) not null,
    estsigla varchar(2) not null,
    paisid integer not null,
    estaltpor integer,
    estincpor integer,
    estaltem timestamp(6),
    estincem timestamp(6),
    primary key (estid)
);

create table tbmunicipio (
    munid integer not null,
    munnom varchar(100) not null,
    estid integer,
    empid integer,
    munativo boolean,
    munmunorigid integer,
    munaltpor integer,
    munincpor integer,
    munaltem timestamp(6),
    munincem timestamp(6),
    primary key (munid)
);

create table tbpessoa (
    pesid integer not null,
    pesnom varchar(200) not null,
    pesemail varchar(100),
    pesend varchar(255),
    pesfisjur varchar(10),
    pescpf varchar(14),
    pescnpj varchar(20),
    pescelcompes varchar(20),
    pescelpes varchar(20),
    pestelcom varchar(20),
    pestelpes varchar(20),
    pescelcomddd varchar(5),
    pescelpesddd varchar(5),
    pestelcomddd varchar(5),
    pestelpesddd varchar(5),
    empid integer not null,
    munid integer not null,
    pesaltpor integer,
    pesincpor integer,
    pesaltem timestamp(6),
    pesincem timestamp(6),
    primary key (pesid)
);

create table tbcliente (
    pesid integer not null,
    cliobs text,
    clialtpor integer,
    cliincpor integer,
    clialtem timestamp(6),
    cliincem timestamp(6),
    primary key (pesid)
);

create table tbfuncionario (
    funcioid integer not null,
    funcioobs text,
    funcioaltpor integer,
    funcioincpor integer,
    funcioaltem timestamp(6),
    funcioincem timestamp(6),
    primary key (funcioid)
);

-- =========================
-- USUÁRIO / SEGURANÇA
-- =========================
create table tbperfil (
    perid integer not null,
    pernom varchar(100) not null,
    empid integer,
    peraltpor integer,
    perincpor integer,
    peraltem timestamp(6),
    perincem timestamp(6),
    primary key (perid)
);

create table tbtela (
    telid integer not null,
    telnom varchar(100) not null,
    telaltpor integer,
    telincpor integer,
    telaltem timestamp(6),
    telincem timestamp(6),
    primary key (telid)
);

create table tbacao (
    acaid integer not null,
    acanom varchar(100) not null,
    acaaltpor integer,
    acaincpor integer,
    acaaltem timestamp(6),
    acaincem timestamp(6),
    primary key (acaid)
);

create table tbusuario (
    usuid integer not null,
    usulogin varchar(50) not null unique,
    ususenha varchar(255),
    usuativo boolean,
    perid integer,
    usualtpor integer,
    usuincpor integer,
    usualtem timestamp(6),
    usuincem timestamp(6),
    primary key (usuid)
);

create table tbpermissaoacesso (
    permaceid integer not null,
    perid integer,
    telid integer,
    acaid integer,
    usuid integer,
    permacesta integer,
    permacealtpor integer,
    permaceincpor integer,
    permacealtem timestamp(6),
    permaceincem timestamp(6),
    primary key (permaceid),
    unique (perid, telid, acaid, usuid)
);

-- =========================
-- PRODUTO / SERVIÇO
-- =========================
create table tbproduto (
    prodid integer not null,
    proddsc varchar(100) not null,
    empid integer not null,
    prodaltpor integer,
    prodincpor integer not null,
    prodsigla varchar(2),
    prodsessao varchar(7),
    prodaltem timestamp(6),
    prodincem timestamp(6) not null,
    primary key (prodid)
);

create table tbservico (
    serid integer not null,
    serdesc text not null,
    serfabricacao text not null,
    empid integer not null,
    ser_sessao_comprimento numeric(5,2),
    sersessaoaltura numeric(5,2),
    sersessaolargura numeric(5,2),
    serincpor integer,
    seraltpor uuid,
    seraltem timestamp(6),
    serincem timestamp(6),
    primary key (serid)
);

create table tbservicocusto (
    sercustoid integer not null,
    sercustonom varchar(200) not null,
    sercustocod varchar(50),
    sercustosta varchar(50),
    sercustouni varchar(10),
    sercustovlrunit numeric(18,2),
    serid integer,
    sercustoincpor integer,
    sercustoaltpor uuid,
    sercustoaltem timestamp(6),
    sercustoincem timestamp(6),
    primary key (sercustoid)
);

create table tbunidade (
    uniid integer not null,
    uninom varchar(100),
    primary key (uniid)
);

-- =========================
-- ORÇAMENTO
-- =========================
create table tborcamentopedido (
    orcpedid integer not null,
    empid integer,
    cliid integer,
    usuid integer,
    orcpedpaiid integer,
    orcpedetapa smallint check (orcpedetapa between 0 and 5),
    orcpeddatsol date,
    orcpeddtaprevent date,
    orcpeddatentpro date,
    orcpedqtddiaresent integer,
    orcpedpesorc numeric(18,2),
    orcpedpesexe numeric(18,2),
    orcpedsalneg numeric(18,2),
    orcpedsalpes numeric(18,2),
    orcpedvalorc numeric(18,2),
    orcpedvalped numeric(18,2),
    orcpednumpro varchar(20),
    orcpeddimtam varchar(100),
    orcpednomobr varchar(255),
    orcpedaltpor integer,
    orcpedincpor integer,
    orcpedaltem timestamp(6),
    orcpedincem timestamp(6),
    primary key (orcpedid)
);

create table tborcamentopedidocustoobra (
    orcpedcustoobrid integer not null,
    orcpedid integer not null,
    sercustoid integer not null,
    uniid integer not null,
    orcpedcustoobrqtd integer,
    orcpedcustoobrvlrunit numeric(18,2),
    orcpedcustoobrfaze integer,
    orcpedcustoobrpron integer,
    orcpedcustoobrsitua integer,
    orcpedcustoobrtipo varchar(50),
    orcpedcustoobraltpor integer,
    orcpedcustoobrincpor integer,
    orcpedcustoobraltem timestamp(6),
    orcpedcustoobrincem timestamp(6),
    primary key (orcpedcustoobrid),
    unique (orcpedid, sercustoid)
);

create table tborcamentopedidocustoobraeng (
    orcpedcustoobrengid integer not null,
    orcpedcustoobrid integer,
    orcpedcustoobrenglote integer,
    orcpedcustoobrengqtdafazer integer,
    orcpedcustoobrengqtdlibparfabr integer,
    orcpedcustoobrengaltpor integer,
    orcpedcustoobrengincpor integer,
    orcpedcustoobrengaltem timestamp(6),
    orcpedcustoobrengincem timestamp(6),
    primary key (orcpedcustoobrengid)
);

create table tborcamentopedidocustoobraengpro (
    orcpedcustoobrengproid integer not null,
    orcpedcustoobrengid integer,
    orcpedcustoobrengproproduto varchar(255),
    orcpedcustoobrengproqtd integer,
    orcpedcustoobrengproaltpor integer,
    orcpedcustoobrengproincpor integer,
    orcpedcustoobrengproaltem timestamp(6),
    orcpedcustoobrengproincem timestamp(6),
    primary key (orcpedcustoobrengproid)
);

create table tborcamentopedidohistorico (
    orcpedhistid integer not null,
    orcpedid integer,
    orcpedetapa integer,
    orcpedhistobs varchar(100),
    orcpedhistincpor integer,
    orcpedhistincem timestamp(6),
    primary key (orcpedhistid)
);

-- =========================
-- FOREIGN KEYS
-- =========================
alter table tbcliente add foreign key (pesid) references tbpessoa;
alter table tbfuncionario add foreign key (funcioid) references tbpessoa;
alter table tbestado add foreign key (paisid) references tbpais;
alter table tbmunicipio add foreign key (estid) references tbestado;
alter table tbpessoa add foreign key (empid) references tbempresa;
alter table tbpessoa add foreign key (munid) references tbmunicipio;
alter table tbproduto add foreign key (empid) references tbempresa;
alter table tbservico add foreign key (empid) references tbempresa;
alter table tborcamentopedidocustoobra add foreign key (orcpedid) references tborcamentopedido;
alter table tborcamentopedidocustoobra add foreign key (sercustoid) references tbservicocusto;
alter table tborcamentopedidocustoobra add foreign key (uniid) references tbunidade;
alter table tborcamentopedidocustoobraeng add foreign key (orcpedcustoobrid) references tborcamentopedidocustoobra;
alter table tborcamentopedidocustoobraengpro add foreign key (orcpedcustoobrengid) references tborcamentopedidocustoobraeng;
alter table tbpermissaoacesso add foreign key (perid) references tbperfil;
alter table tbpermissaoacesso add foreign key (telid) references tbtela;
alter table tbpermissaoacesso add foreign key (acaid) references tbacao;
alter table tbpermissaoacesso add foreign key (usuid) references tbusuario;
alter table tbusuario add foreign key (usuid) references tbpessoa;
alter table tbusuario add foreign key (perid) references tbperfil;
