package br.senac.ead.alerta_verde.controllers;

import br.senac.ead.alerta_verde.dto.DenunciaDTO;
import br.senac.ead.alerta_verde.dto.DenunciaMinDTO;
import br.senac.ead.alerta_verde.dto.UsuarioMinDTO;
import br.senac.ead.alerta_verde.entities.Denuncia;
import br.senac.ead.alerta_verde.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {
    @Autowired
    private DenunciaService service;

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DenunciaDTO>> findById(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<DenunciaMinDTO> create(@RequestBody DenunciaDTO dto){
        DenunciaMinDTO created = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }
}
