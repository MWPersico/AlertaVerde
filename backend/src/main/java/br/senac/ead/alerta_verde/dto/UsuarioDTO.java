package br.senac.ead.alerta_verde.dto;

import br.senac.ead.alerta_verde.entities.Usuario;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {
    private final Integer id;
    private final String nome;
    private final String email;
    private final String senhaHash;
    private final String telefone;
    private final Set<DenunciaMinDTO> denuncias = new HashSet<>();

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
