package br.senac.ead.alerta_verde.enums;

import br.senac.ead.alerta_verde.interfaces.EnumComDescricao;

public enum CategoriaDenunciaEnum implements EnumComDescricao {
    DESMATAMENTO(0, "DESMATAMENTO"),
    POLUICAO(1, "POLUICAO"),
    ANIMAIS_EM_RISCO(2, "ANIMAIS_EM_RISCO"),
    OUTRO(3, "OUTRO");

    private final int id;
    private final String descricao;

    CategoriaDenunciaEnum(int id, String descricao) {
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
