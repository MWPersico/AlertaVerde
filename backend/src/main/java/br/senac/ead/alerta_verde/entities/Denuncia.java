package br.senac.ead.alerta_verde.entities;

import br.senac.ead.alerta_verde.enums.CategoriaDenunciaEnum;
import br.senac.ead.alerta_verde.enums.StatusDenunciaEnum;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tb_denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private CategoriaDenunciaEnum categoria;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataDenuncia;
    private Double latitude;
    private Double longitude;
    private Boolean anonima;
    private StatusDenunciaEnum status;
    private String codigoRastreamento;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "denuncia")
    private Set<MidiaDenuncia> midias = new HashSet<>();

    public Denuncia(){}

    public Denuncia(Integer id, String titulo, String descricao, CategoriaDenunciaEnum categoria, Instant dataDenuncia, Double latitude, Double longitude, Boolean anonima, StatusDenunciaEnum status, String codigoRastreamento, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataDenuncia = dataDenuncia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.anonima = anonima;
        this.status = status;
        this.codigoRastreamento = codigoRastreamento;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaDenunciaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDenunciaEnum categoria) {
        this.categoria = categoria;
    }

    public Instant getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Instant dataDenuncia) {
        dataDenuncia = dataDenuncia;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getAnonima() {
        return anonima;
    }

    public void setAnonima(Boolean anonima) {
        this.anonima = anonima;
    }

    public StatusDenunciaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusDenunciaEnum status) {
        this.status = status;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Set<MidiaDenuncia> getMidias(){
        return midias;
    }

    public void addMidia(MidiaDenuncia midiaDenuncia){
        this.midias.add(midiaDenuncia);
    }
}
