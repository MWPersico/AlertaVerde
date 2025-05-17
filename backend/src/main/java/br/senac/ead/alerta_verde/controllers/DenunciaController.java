package br.senac.ead.alerta_verde.controllers;

import br.senac.ead.alerta_verde.dto.DenunciaDTO;
import br.senac.ead.alerta_verde.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
