package br.senac.ead.alerta_verde.controllers;

import br.senac.ead.alerta_verde.dto.SimpleEnumDTO;
import br.senac.ead.alerta_verde.enums.CategoriaDenunciaEnum;
import br.senac.ead.alerta_verde.enums.StatusDenunciaEnum;
import br.senac.ead.alerta_verde.enums.TipoArquivoEnum;
import br.senac.ead.alerta_verde.interfaces.EnumComDescricao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enums")
public class EnumsController {

    @GetMapping("/categoriaDenuncia")
    public ResponseEntity<Set<SimpleEnumDTO>> listarCategoriaDenuncia(){
        return ResponseEntity.ok(getListaEnum(CategoriaDenunciaEnum.class));
    }

    @GetMapping("/statusDenuncia")
    public ResponseEntity<Set<SimpleEnumDTO>> listarStatusDenuncia(){
        return ResponseEntity.ok(getListaEnum(StatusDenunciaEnum.class));
    }

    @GetMapping("/tipoArquivo")
    public ResponseEntity<Set<SimpleEnumDTO>> listarTipoArquivo(){
        return ResponseEntity.ok(getListaEnum(TipoArquivoEnum.class));
    }

    private static <E extends Enum<E> & EnumComDescricao> Set<SimpleEnumDTO> getListaEnum(Class<E> classeEnum){
        return Arrays
                .stream(classeEnum.getEnumConstants())
                .map(x->new SimpleEnumDTO(x.getId(), x.getDescricao()))
                .sorted((a, b)-> !a.id().equals(b.id()) ? (a.id()>b.id() ? 1 : -1) : 0)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
