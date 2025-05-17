package br.senac.ead.alerta_verde.enums;

import br.senac.ead.alerta_verde.interfaces.EnumComDescricao;

public enum TipoArquivoEnum implements EnumComDescricao {
    IMAGEM(0, "Imagem"),
    VIDEO(1, "Video");

    private final int id;
    private final String descricao;

    TipoArquivoEnum(int id, String descricao) {
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
