package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {
    private Integer id;
    @NotEmpty
    private String nome;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String senhaHash;
    private String telefone;
    private Set<DenunciaMinDTO> denuncias = new HashSet<>();

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senhaHash = usuario.getSenhaHash();
        telefone = usuario.getTelefone();
        denuncias.addAll(usuario.getDenuncias().stream().map(DenunciaMinDTO::new).toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public String getTelefone() {
        return telefone;
    }

    public Set<DenunciaMinDTO> getDenuncias() {
        return denuncias;
    }
}
