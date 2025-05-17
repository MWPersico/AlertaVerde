package br.senac.ead.alerta_verde.enums;

import br.senac.ead.alerta_verde.interfaces.EnumComDescricao;

public enum CategoriaDenunciaEnum implements EnumComDescricao {
    DESMATAMENTO(0, "Desmatamento"),
    POLUICAO(1, "Poluição"),
    ANIMAIS_EM_RISCO(2, "Animais em Risco"),
    OUTRO(3, "Outro");

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
