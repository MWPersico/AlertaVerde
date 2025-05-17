package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.MidiaDenuncia;
import br.senac.ead.alerta_verde.enums.TipoArquivoEnum;

public class MidiaDenunciaMinDTO {
    private final Integer id;
    private final String urlArquivo;
    private final TipoArquivoEnum tipo;

    public MidiaDenunciaMinDTO(MidiaDenuncia midiaDenuncia){
        id = midiaDenuncia.getId();
        urlArquivo = midiaDenuncia.getUrlArquivo();
        tipo = midiaDenuncia.getTipo();
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
}
