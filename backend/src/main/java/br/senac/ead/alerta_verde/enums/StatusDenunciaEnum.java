package br.senac.ead.alerta_verde.enums;

import br.senac.ead.alerta_verde.interfaces.EnumComDescricao;

public enum StatusDenunciaEnum implements EnumComDescricao {
    RECEBIDA(0 ,"Recebida"),
    EM_ANALISE(1 ,"Em Análise"),
    RESOLVIDA(2 ,"Resolvida");

    private final int id;
    private final String descricao;

    StatusDenunciaEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
