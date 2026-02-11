#Costumo usar o Hibernate para gerar um DDL inicial, revisar o script e executar manualmente ou versionar via Flyway(no momento desabilitado).
CREATE TABLE tbpessoa (
    pesid SERIAL PRIMARY KEY,
    pesnom VARCHAR(150) NOT NULL,
    pescpf VARCHAR(14),
    pescnpj VARCHAR(18),
    pesemail VARCHAR(150),
    pesend TEXT,
    munid INT,
    empid INT,
    pesfisjur CHAR(1),
    pestelpesddd VARCHAR(3),
    pestelpes VARCHAR(20),
    pestelcomddd VARCHAR(3),
    pestelcom VARCHAR(20),
    pescelpesddd VARCHAR(3),
    pescelpes VARCHAR(20),
    pescelcomddd VARCHAR(3),
    pescelcompes VARCHAR(20),
    pesincpor INT,
    pesincem TIMESTAMPTZ,
    pesaltpor INT,
    pesaltem TIMESTAMPTZ
);
