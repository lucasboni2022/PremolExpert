-- Criação das tabelas necessárias para autenticação e autorização

-- Tabela de Empresa
CREATE TABLE IF NOT EXISTS tbempresa (
    empid SERIAL PRIMARY KEY,
    empnom VARCHAR(200) NOT NULL,
    empincpor INT,
    empincem TIMESTAMPTZ,
    empaltpor INT,
    empaltem TIMESTAMPTZ
);

-- Tabela de Perfil
CREATE TABLE IF NOT EXISTS tbperfil (
    perid SERIAL PRIMARY KEY,
    pernom VARCHAR(100) NOT NULL,
    empid INT NOT NULL,
    perincpor INT,
    perincem TIMESTAMPTZ,
    peraltpor INT,
    peraltem TIMESTAMPTZ,
    FOREIGN KEY (empid) REFERENCES tbempresa(empid)
);

-- Tabela de Usuário
CREATE TABLE IF NOT EXISTS tbusuario (
    usuid SERIAL PRIMARY KEY,
    pesid INT NOT NULL,
    usulogin VARCHAR(50) NOT NULL UNIQUE,
    ususenha VARCHAR(255),
    empid INT NOT NULL,
    usuativo BOOLEAN,
    usuincpor INT,
    usuincem TIMESTAMPTZ,
    usualtpor INT,
    usualtem TIMESTAMPTZ,
    perid INT,
    FOREIGN KEY (pesid) REFERENCES tbpessoa(pesid),
    FOREIGN KEY (empid) REFERENCES tbempresa(empid),
    FOREIGN KEY (perid) REFERENCES tbperfil(perid)
);

-- Tabela de Tela
CREATE TABLE IF NOT EXISTS tbtela (
    telid SERIAL PRIMARY KEY,
    telnom VARCHAR(100) NOT NULL,
    telincpor INT,
    telincem TIMESTAMPTZ,
    telaltpor INT,
    telaltem TIMESTAMPTZ
);

-- Tabela de Ação
CREATE TABLE IF NOT EXISTS tbacao (
    acaid SERIAL PRIMARY KEY,
    acanom VARCHAR(100) NOT NULL,
    acaincpor INT,
    acaincem TIMESTAMPTZ,
    acaaltpor INT,
    acaaltem TIMESTAMPTZ
);

-- Tabela de Permissão de Acesso
CREATE TABLE IF NOT EXISTS tbpermissaoacesso (
    permaceid SERIAL PRIMARY KEY,
    perid INT,
    telid INT,
    acaid INT,
    usuid INT,
    permacestat INT,
    empid INT NOT NULL,
    permaceincpor INT,
    permaceincem TIMESTAMPTZ,
    permacealtpor INT,
    permacealtem TIMESTAMPTZ,
    FOREIGN KEY (perid) REFERENCES tbperfil(perid),
    FOREIGN KEY (telid) REFERENCES tbtela(telid),
    FOREIGN KEY (acaid) REFERENCES tbacao(acaid),
    FOREIGN KEY (usuid) REFERENCES tbusuario(usuid),
    FOREIGN KEY (empid) REFERENCES tbempresa(empid),
    UNIQUE(perid, telid, acaid, usuid)
);

-- Inserir uma Empresa padrão
INSERT INTO tbempresa (empnom, empincpor, empincem)
SELECT 'PreMolExpert', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM tbempresa LIMIT 1);

-- Inserir um Perfil padrão (Administrador)
INSERT INTO tbperfil (pernom, empid, perincpor, perincem)
SELECT 'Administrador', (SELECT empid FROM tbempresa LIMIT 1), 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM tbperfil LIMIT 1);

