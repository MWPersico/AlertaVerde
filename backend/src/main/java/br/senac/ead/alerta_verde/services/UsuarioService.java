package br.senac.ead.alerta_verde.services;

import br.senac.ead.alerta_verde.dto.UsuarioDTO;
import br.senac.ead.alerta_verde.exceptions.ResourceNotFoundException;
import br.senac.ead.alerta_verde.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
