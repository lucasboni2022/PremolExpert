-- 1. Tabelas com apenas chaves primárias (sem referências externas)

CREATE TABLE TBPais (
    PaisId INT AUTO_INCREMENT NOT NULL,
    PaisNom VARCHAR(100) NOT NULL,
    PaisIncPor INT NOT NULL,
    PaisIncEm DATE NOT NULL,
    PaisAltPor INT NULL,
    PaisAltEm DATE NULL,
    PaisSigla VARCHAR(2) NULL,
    PRIMARY KEY (PaisId)
);

CREATE TABLE TBEstado (
    EstId INT AUTO_INCREMENT NOT NULL,
    EstNom VARCHAR(100) NOT NULL,
    EstIncPor INT NOT NULL,
    EstIncEm DATE NOT NULL,
    EstAltPor INT NULL,
    EstAltEm DATE NULL,
    PaisId INT NOT NULL,
    EstSigla VARCHAR(2) NULL,
    PRIMARY KEY (EstId),
    FOREIGN KEY (PaisId) REFERENCES TBPais(PaisId)
);

CREATE TABLE TBProduto (
    ProdId INT AUTO_INCREMENT NOT NULL,
    ProdNom VARCHAR(100) NOT NULL,
    ProdDsc VARCHAR(500) NULL,
    ProdCodProd VARCHAR(50) NULL,
    ProdIncPor INT NOT NULL,
    ProdIncEm DATETIME NOT NULL,
    ProdAltPor INT NULL,
    ProdAltEm DATETIME NULL,
	GruId int,
    PRIMARY KEY (ProdId)
);

CREATE TABLE TBUnidade (
    UniId INT AUTO_INCREMENT NOT NULL,
    UniDsc VARCHAR(50) NULL,
    UniIncPor INT NOT NULL,
    UniIncEm DATETIME NOT NULL,
    UniAltPor INT NULL,
    UniAltEm DATETIME NULL,
    PRIMARY KEY (UniId)
);

CREATE TABLE TBGrupo (
    GruId INT AUTO_INCREMENT NOT NULL,
    GruDsc VARCHAR(100) NULL,
    GruIncPor INT NOT NULL,
    GruIncEm DATE NOT NULL,
    GruAltPor INT NULL,
    GruAltEm DATE NULL,
    EmpId INT NOT NULL,
    PRIMARY KEY (GruId)
);


CREATE TABLE TBCliente (
    CliId INT AUTO_INCREMENT NOT NULL,
    PesId INT NOT NULL,
    CliObs VARCHAR(200) NULL,
    CliIncPor INT NOT NULL,
    CliIncEm DATE NOT NULL,
    CliAltPor INT NULL,
    CliAltEm DATE NULL,
    PRIMARY KEY (CliId)
);

CREATE TABLE TBClienteRepresentante (
    CliRepId INT AUTO_INCREMENT NOT NULL,
    CliId INT NULL,
    CliRepNom VARCHAR(100) NOT NULL,
    CliRepTelDDD INT(2) NULL,
    CliRepTel INT(9) NULL,
    CliRepEmail VARCHAR(100) NULL,
    CliRepIncPor INT NOT NULL,
    CliRepIncEm DATE NOT NULL,
    CliRepAltPor INT NULL,
    CliRepAltEm DATE NULL,
    PRIMARY KEY (CliRepId)
);

CREATE TABLE TBEmpresa (
    EmpId INT NOT NULL,
    EmpNom VARCHAR(150) NULL,
    EmpIncPor INT NOT NULL,
    EmpIncEm DATE NOT NULL,
    EmpAltPor INT NULL,
    EmpAltEm DATE NULL,
    PRIMARY KEY (EmpId)
);




CREATE TABLE TBMunicipio (
    MunId INT AUTO_INCREMENT NOT NULL,
    MunNom VARCHAR(100) NOT NULL,
    MunIncPor INT NOT NULL,
    MunIncEm DATE NOT NULL,
    MunAltPor INT NULL,
    MunAltEm DATE NULL,
    EstId INT NOT NULL,
    PRIMARY KEY (MunId),
    FOREIGN KEY (EstId) REFERENCES TBEstado(EstId)
);


CREATE TABLE TBPessoa (
    PesId INT AUTO_INCREMENT NOT NULL,
    PesNom VARCHAR(100) NOT NULL,
    PesCpf BIGINT NULL,
    PesCnpj BIGINT NULL,
    PesEmail VARCHAR(100) NULL,
    PesTelPesDDD INT(2) NULL,
    PesTelPes INT(9) NULL,
    PesTelComDDD INT(2) NULL,
    PesTelCom INT(9) NULL,
    PesCelPesDDD INT(2) NULL,
    PesCelPes INT(9) NULL,
    PesCelComDDD INT(2) NULL,
    PesCelComPes INT(9) NULL,
    PesEnd VARCHAR(200) NULL,
    MunId INT NULL,
    EmpId INT NOT NULL,
    PesFisJur INT NOT NULL,
    PesIncPor INT NOT NULL,
    PesIncEm DATE NOT NULL,
    PesAltPor INT NULL,
    PesAltEm DATE NULL,
    PRIMARY KEY (PesId)
);

CREATE TABLE TBUsuario (
    UsuId INT AUTO_INCREMENT NOT NULL,
    UsuLogin VARCHAR(100) NOT NULL,
    UsuSenha VARCHAR(50) NULL,
    UsuPerCod DECIMAL(1, 0) NOT NULL,
    PesId INT NOT NULL,
    UsuIncPor INT NOT NULL,
    UsuIncEm DATE NOT NULL,
    UsuAltPor INT NULL,
    UsuAltEm DATE NULL,
    PRIMARY KEY (UsuId)
);

-- 2. Tabelas que possuem chaves estrangeiras

CREATE TABLE TBEmpresaResponsavel (
    EmpResId INT AUTO_INCREMENT NOT NULL,
    EmpId INT NOT NULL,
    PesId INT NOT NULL,
    EmpResIncPor INT NOT NULL,
    EmpResIncEm DATE NOT NULL,
    EmpResAltPor INT NULL,
    EmpResAltEm DATE NULL,
    PRIMARY KEY (EmpResId),
    FOREIGN KEY (EmpId) REFERENCES TBEmpresa(EmpId),
    FOREIGN KEY (PesId) REFERENCES TBPessoa(PesId)
);

CREATE TABLE TBOrcamentoPedido (
    OrcPedId INT AUTO_INCREMENT NOT NULL,
    OrcPedNumPro VARCHAR(20) NOT NULL,
    CliId INT NOT NULL,
    OrcPedNomObr VARCHAR(255) NULL,
    OrcPedDatSol DATE NOT NULL,
    OrcPedDtaPrevEnt DATE NULL,
    OrcPedDimTam VARCHAR(100) NULL,
    UsuId INT NOT NULL,
    OrcPedSta INT NOT NULL,
    OrcPedValOrc DECIMAL(18, 2) NULL,
    OrcPedDatEntPro DATE NULL,
    OrcPedQtdDiaResEnt INT NULL,
    OrcPedValPed DECIMAL(18, 2) NULL,
    OrcPedSalNeg DECIMAL(18, 2) NULL,
    OrcPedPesOrc DECIMAL(18, 2) NULL,
    OrcPedPesExe DECIMAL(18, 2) NULL,
    OrcPedSalPes DECIMAL(18, 2) NULL,
    OrcPedIncPor INT NOT NULL,
    OrcPedIncEm DATETIME NOT NULL,
    OrcPedAltPor INT NULL,
    OrcPedAltEm DATETIME NULL,
    EmpId INT NOT NULL,
    OrcPedPaiOrcPedId INT NULL,
    PRIMARY KEY (OrcPedId),
    FOREIGN KEY (CliId) REFERENCES TBCliente(CliId),
    FOREIGN KEY (EmpId) REFERENCES TBEmpresa(EmpId),
    FOREIGN KEY (UsuId) REFERENCES TBUsuario(UsuId)
);

CREATE TABLE TBOrcamentoPedidoHistorico (
    OrcPedHistId INT AUTO_INCREMENT NOT NULL,
    OrcPedId INT NOT NULL,
    OrcPedProdSta INT NOT NULL,
    OrcPedProdIncPor INT NOT NULL,
    OrcPedProdIncEm DATETIME NOT NULL,
    PRIMARY KEY (OrcPedHistId),
    FOREIGN KEY (OrcPedId) REFERENCES TBOrcamentoPedido(OrcPedId)
);

CREATE TABLE TBOrcamentoPedidoProduto (
    OrcPedProdId INT AUTO_INCREMENT NOT NULL,
    OrcPedId INT NOT NULL,
    ProdId INT NOT NULL,
    UniId INT NOT NULL,
    OrcPedProdQtd INT NOT NULL,
    OrcPedProdVlrUnit DECIMAL(18, 2) NOT NULL,
    OrcPedProdPron INT NOT NULL,
    OrcPedProdAFaze INT NOT NULL,
    OrcPedProdSta INT NOT NULL,
    OrcPedProdIncPor INT NOT NULL,
    OrcPedProdIncEm DATETIME NOT NULL,
    OrcPedProdAltPor INT NULL,
    OrcPedProdAltEm DATETIME NULL,
    PRIMARY KEY (OrcPedProdId),
    FOREIGN KEY (OrcPedId) REFERENCES TBOrcamentoPedido(OrcPedId),
    FOREIGN KEY (ProdId) REFERENCES TBProduto(ProdId),
    FOREIGN KEY (UniId) REFERENCES TBUnidade(UniId)
);

CREATE TABLE TBOrcamentoPedidoProdutoFab (
    OrcPedProdFabId INT AUTO_INCREMENT NOT NULL,
    OrcPedProdId INT NOT NULL,
    OrcPedProdFabSta INT NOT NULL,
    OrcPedProdFabDtaAco DATETIME NOT NULL,
    OrcPedProdFabDtaCon DATETIME NOT NULL,
    OrcPedProdFabDtaLib DATETIME NOT NULL,
    OrcPedProdFabDtaTra DATETIME NOT NULL,
    OrcPedProdFabDtaMon DATETIME NOT NULL,
    OrcPedProdFabIncPor INT NOT NULL,
    OrcPedProdFabIncEm DATETIME NOT NULL,
    OrcPedProdFabAltPor INT NULL,
    OrcPedProdFabAltEm DATETIME NULL,
    PRIMARY KEY (OrcPedProdFabId),
    FOREIGN KEY (OrcPedProdId) REFERENCES TBOrcamentoPedidoProduto(OrcPedProdId)
);

CREATE TABLE TBOrcamentoPedidoProdutoFabPro (
    OrcPedProdFaProbId INT AUTO_INCREMENT NOT NULL,
    OrcPedProdFabId INT NOT NULL,
    OrcPedProdFabProDta INT NOT NULL,
    OrcPedProdFabProIncPor INT NOT NULL,
    OrcPedProdFabProIncEm DATETIME NOT NULL,
    OrcPedProdFabProAltPor INT NULL,
    OrcPedProdFabProAltEm DATETIME NULL,
    PRIMARY KEY (OrcPedProdFaProbId),
    FOREIGN KEY (OrcPedProdFabId) REFERENCES TBOrcamentoPedidoProdutoFab(OrcPedProdFabId)
);

