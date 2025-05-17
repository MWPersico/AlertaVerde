package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Denuncia;
import br.senac.ead.alerta_verde.enums.CategoriaDenunciaEnum;
import br.senac.ead.alerta_verde.enums.StatusDenunciaEnum;

import java.time.Instant;
import java.util.HashSet;

public class DenunciaMinDTO {
    private final Integer id;
    private final String titulo;
    private final String descricao;
    private final CategoriaDenunciaEnum categoria;
    private final Instant dataDenuncia;
    private final StatusDenunciaEnum status;

    public DenunciaMinDTO(Denuncia denuncia){
        id = denuncia.getId();
        titulo = denuncia.getTitulo();
        descricao = denuncia.getDescricao();
        categoria = denuncia.getCategoria();
        dataDenuncia = denuncia.getDataDenuncia();
        status = denuncia.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public CategoriaDenunciaEnum getCategoria() {
        return categoria;
    }

    public Instant getDataDenuncia() {
        return dataDenuncia;
    }

    public StatusDenunciaEnum getStatus() {
        return status;
    }
}
