package br.senac.ead.alerta_verde.services;

import br.senac.ead.alerta_verde.dto.DenunciaDTO;
import br.senac.ead.alerta_verde.exceptions.ResourceNotFoundException;
import br.senac.ead.alerta_verde.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository repository;

    @Transactional(readOnly = true)
    public DenunciaDTO findById(Integer id){
        return new DenunciaDTO(repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Denúncia não encontrada")));
    }

    @Transactional(readOnly = true)
    public List<DenunciaDTO> findAll(){
        return repository.findAll().stream().map(DenunciaDTO::new).toList();
    }
}
