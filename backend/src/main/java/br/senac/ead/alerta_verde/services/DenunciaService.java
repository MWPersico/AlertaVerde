package br.senac.ead.alerta_verde.services;

import br.senac.ead.alerta_verde.dto.DenunciaDTO;
import br.senac.ead.alerta_verde.dto.DenunciaMinDTO;
import br.senac.ead.alerta_verde.dto.MidiaDenunciaMinDTO;
import br.senac.ead.alerta_verde.dto.UsuarioDTO;
import br.senac.ead.alerta_verde.entities.Denuncia;
import br.senac.ead.alerta_verde.entities.MidiaDenuncia;
import br.senac.ead.alerta_verde.entities.Usuario;
import br.senac.ead.alerta_verde.exceptions.ResourceNotFoundException;
import br.senac.ead.alerta_verde.repositories.DenunciaRepository;
import br.senac.ead.alerta_verde.repositories.MidiaDenunciaRepository;
import br.senac.ead.alerta_verde.repositories.UsuarioRepository;
import br.senac.ead.alerta_verde.utils.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Random;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MidiaDenunciaRepository midiaDenunciaRepository;

    @Transactional(readOnly = true)
    public DenunciaDTO findById(Integer id){
        return new DenunciaDTO(repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Denúncia não encontrada")));
    }

    @Transactional(readOnly = true)
    public List<DenunciaDTO> findAll(){
        return repository.findAll().stream().map(DenunciaDTO::new).toList();
    }

    @Transactional
    public DenunciaMinDTO create(DenunciaDTO dto){
        Denuncia denuncia = new Denuncia();
        mergeDenuncia(dto, denuncia);

        Denuncia created = repository.save(denuncia);
        salvarMidias(dto, denuncia);

        return new DenunciaMinDTO(created);
    }

    private void mergeDenuncia(DenunciaDTO dto, Denuncia denuncia){
        denuncia.setTitulo(dto.getTitulo());
        denuncia.setDescricao(dto.getDescricao());
        denuncia.setDataDenuncia(Instant.now());
        denuncia.setAnonima(dto.getAnonima());
        denuncia.setCategoria(dto.getCategoria());
        denuncia.setLatitude(dto.getLatitude());
        denuncia.setLongitude(dto.getLongitude());
        denuncia.setCodigoRastreamento(getCodigoRastreamento());
        denuncia.setStatus(dto.getStatus());
        denuncia.setUsuario(usuarioRepository.getReferenceById(dto.getUsuario().getId()));
    }

    private void salvarMidias(DenunciaDTO dto, Denuncia denuncia){
        for(MidiaDenunciaMinDTO midiaDTO : dto.getMidias()){
            MidiaDenuncia midia = new MidiaDenuncia();

            midia.setDenuncia(denuncia);
            midia.setTipo(midiaDTO.getTipo());
            midia.setUrlArquivo(midiaDTO.getUrlArquivo());
            midiaDenunciaRepository.save(midia);
        }
    }

    private String getCodigoRastreamento() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
