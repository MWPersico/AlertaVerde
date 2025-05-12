package br.senac.ead.alerta_verde.entities;

import jakarta.persistence.*;

import java.util.HashSet;

@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senhaHash;
    private String telefone;
    @OneToMany(mappedBy = "usuario")
    private HashSet<Denuncia> denuncias = new HashSet<>();

    public Usuario(){}

    public Usuario(Integer id, String nome, String email, String senhaHash, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public HashSet<Denuncia> getDenuncias(){
        return denuncias;
    }

    public void addDenuncia(Denuncia denuncia){
        denuncias.add(denuncia);
    }
}
