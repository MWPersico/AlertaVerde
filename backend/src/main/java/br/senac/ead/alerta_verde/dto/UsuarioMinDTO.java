package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Usuario;
import jakarta.validation.constraints.NotEmpty;

public class UsuarioMinDTO {
    @NotEmpty
    private Integer id;
    private String nome;
    private String email;

    public UsuarioMinDTO(){}

    public UsuarioMinDTO(Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
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
}
