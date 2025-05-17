package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Denuncia;
import br.senac.ead.alerta_verde.enums.CategoriaDenunciaEnum;
import br.senac.ead.alerta_verde.enums.StatusDenunciaEnum;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class DenunciaDTO {
    private final Integer id;
    private final String titulo;
    private final String descricao;
    private final CategoriaDenunciaEnum categoria;
    private final Instant dataDenuncia;
    private final Double latitude;
    private final Double longitude;
    private final Boolean anonima;
    private final StatusDenunciaEnum status;
    private final String codigoRastreamento;
    private final UsuarioMinDTO usuario;
    private final Set<MidiaDenunciaMinDTO> midias = new HashSet<>();

    public DenunciaDTO(Denuncia denuncia){
        id = denuncia.getId();
        titulo = denuncia.getTitulo();
        descricao = denuncia.getDescricao();
        categoria = denuncia.getCategoria();
        dataDenuncia = denuncia.getDataDenuncia();
        latitude = denuncia.getLatitude();
        longitude = denuncia.getLongitude();
        anonima = denuncia.getAnonima();
        status = denuncia.getStatus();
        codigoRastreamento = denuncia.getCodigoRastreamento();
        usuario = new UsuarioMinDTO(denuncia.getUsuario());
        midias.addAll(denuncia.getMidias().stream().map(MidiaDenunciaMinDTO::new).toList());
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

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Boolean getAnonima() {
        return anonima;
    }

    public StatusDenunciaEnum getStatus() {
        return status;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public UsuarioMinDTO getUsuario() {
        return usuario;
    }

    public Set<MidiaDenunciaMinDTO> getMidias() {
        return midias;
    }
}
