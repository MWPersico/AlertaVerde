package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.MidiaDenuncia;
import br.senac.ead.alerta_verde.enums.TipoArquivoEnum;

public class MidiaDenunciaMinDTO {
    private Integer id;
    private String urlArquivo;
    private TipoArquivoEnum tipo;
    private Integer idDenuncia;

    public MidiaDenunciaMinDTO(){}

    public MidiaDenunciaMinDTO(MidiaDenuncia midiaDenuncia){
        id = midiaDenuncia.getId();
        urlArquivo = midiaDenuncia.getUrlArquivo();
        tipo = midiaDenuncia.getTipo();
        idDenuncia = midiaDenuncia.getDenuncia().getId();
    }

    public Integer getId() {
        return id;
    }

    public String getUrlArquivo() {
        return urlArquivo;
    }

    public TipoArquivoEnum getTipo() {
        return tipo;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }
}
