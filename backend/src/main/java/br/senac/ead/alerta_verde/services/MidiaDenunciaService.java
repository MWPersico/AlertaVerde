package br.senac.ead.alerta_verde.services;

import br.senac.ead.alerta_verde.dto.MidiaDenunciaMinDTO;
import br.senac.ead.alerta_verde.entities.MidiaDenuncia;
import br.senac.ead.alerta_verde.repositories.DenunciaRepository;
import br.senac.ead.alerta_verde.repositories.MidiaDenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MidiaDenunciaService {
    @Autowired
    private MidiaDenunciaRepository repository;

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Transactional
    public MidiaDenunciaMinDTO create(MidiaDenunciaMinDTO dto){
        MidiaDenuncia midia = new MidiaDenuncia();

        midia.setTipo(dto.getTipo());
        midia.setUrlArquivo(dto.getUrlArquivo());
        midia.setDenuncia(denunciaRepository.getReferenceById(dto.getIdDenuncia()));

        return new MidiaDenunciaMinDTO(repository.save(midia));
    }
}
