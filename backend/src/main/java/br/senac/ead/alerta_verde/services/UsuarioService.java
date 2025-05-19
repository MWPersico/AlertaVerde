package br.senac.ead.alerta_verde.services;

import br.senac.ead.alerta_verde.dto.UsuarioDTO;
import br.senac.ead.alerta_verde.dto.UsuarioMinDTO;
import br.senac.ead.alerta_verde.entities.Usuario;
import br.senac.ead.alerta_verde.exceptions.ResourceNotFoundException;
import br.senac.ead.alerta_verde.repositories.UsuarioRepository;
import br.senac.ead.alerta_verde.utils.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Integer id){
        return new UsuarioDTO(repository.findByIdWithDenuncias(id).orElseThrow(()->new ResourceNotFoundException("Usuario não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll(){
        return repository.findAllWithDenuncias().stream().map(UsuarioDTO::new).toList();
    }

    @Transactional
    public UsuarioMinDTO create(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        mergeUsuario(dto, usuario);

        return new UsuarioMinDTO(repository.save(usuario));
    }

    private void mergeUsuario(UsuarioDTO dto, Usuario usuario){
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setSenhaHash(PasswordEncoder.bCryptEncoder.encode(dto.getSenhaHash()));
    }

    @Transactional(readOnly = true)
    public Usuario findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
