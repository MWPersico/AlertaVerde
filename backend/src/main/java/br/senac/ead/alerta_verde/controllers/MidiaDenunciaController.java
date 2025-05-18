package br.senac.ead.alerta_verde.controllers;

import br.senac.ead.alerta_verde.dto.MidiaDenunciaMinDTO;
import br.senac.ead.alerta_verde.dto.UsuarioMinDTO;
import br.senac.ead.alerta_verde.services.MidiaDenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/midiaDenuncia")
public class MidiaDenunciaController {
    @Autowired
    private MidiaDenunciaService service;

    @PostMapping
    public ResponseEntity<MidiaDenunciaMinDTO> create(@RequestBody MidiaDenunciaMinDTO dto){
        MidiaDenunciaMinDTO created = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }
}
