package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Usuario;

public class UsuarioMinDTO {
    private final Integer id;
    private final String nome;
    private final String email;

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
