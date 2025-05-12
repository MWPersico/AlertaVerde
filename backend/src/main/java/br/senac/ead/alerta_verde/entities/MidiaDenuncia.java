package br.senac.ead.alerta_verde.entities;

import br.senac.ead.alerta_verde.enums.TipoArquivoEnum;
import jakarta.persistence.*;

@Entity
@Table(name="tb_midia_denuncia")
public class MidiaDenuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url_arquivo;
    private TipoArquivoEnum tipo;
    @ManyToOne
    @JoinColumn(name="id_denuncia")
    private Denuncia denuncia;

    public MidiaDenuncia(){}

    public MidiaDenuncia(Integer id, String url_arquivo, TipoArquivoEnum tipo, Denuncia denuncia) {
        this.id = id;
        this.url_arquivo = url_arquivo;
        this.tipo = tipo;
        this.denuncia = denuncia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl_arquivo() {
        return url_arquivo;
    }

    public void setUrl_arquivo(String url_arquivo) {
        this.url_arquivo = url_arquivo;
    }

    public TipoArquivoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoArquivoEnum tipo) {
        this.tipo = tipo;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}
