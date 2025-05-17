package br.senac.ead.alerta_verde.entities;

import br.senac.ead.alerta_verde.enums.TipoArquivoEnum;
import jakarta.persistence.*;

@Entity
@Table(name="tb_midia_denuncia")
public class MidiaDenuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String urlArquivo;
    private TipoArquivoEnum tipo;
    @ManyToOne
    @JoinColumn(name="id_denuncia")
    private Denuncia denuncia;

    public MidiaDenuncia(){}

    public MidiaDenuncia(Integer id, String urlArquivo, TipoArquivoEnum tipo, Denuncia denuncia) {
        this.id = id;
        this.urlArquivo = urlArquivo;
        this.tipo = tipo;
        this.denuncia = denuncia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlArquivo() {
        return urlArquivo;
    }

    public void setUrlArquivo(String urlArquivo) {
        this.urlArquivo = urlArquivo;
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
