package com.premolexpert.api.enums;

public enum OrcEtapEnum {
    ORCAMENTO("Orçamento"),               // 0
    ORCAMENTO_APROVADO("Orçamento Aprovado"),      // 1
    ENGENHARIA("Engenharia"),              // 2
    FABRICACAO("Fabricação"),              // 3
    TRANSPORTE("Transporte"),              // 4
    MONTAGEM("Montagem");                  // 5

    private final String descricao;

    // Construtor para armazenar a descrição
    OrcEtapEnum(String descricao) {
        this.descricao = descricao;
    }

    // Método para acessar a descrição
    public String getDescricao() {
        return descricao;
    }
}
