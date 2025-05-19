package br.senac.ead.alerta_verde.controllers;

import br.senac.ead.alerta_verde.dto.UsuarioDTO;
import br.senac.ead.alerta_verde.dto.UsuarioMinDTO;
import br.senac.ead.alerta_verde.entities.Usuario;
import br.senac.ead.alerta_verde.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioMinDTO> create(@RequestBody UsuarioDTO dto){
        UsuarioMinDTO created = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Usuario usuario = service.findByEmail(email);
        if (usuario != null && br.senac.ead.alerta_verde.utils.security.PasswordEncoder.bCryptEncoder.matches(password, usuario.getSenhaHash())) {
            return ResponseEntity.ok().body(new UsuarioMinDTO(usuario));
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}
