package br.senac.ead.alerta_verde.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String home() {
        return "tela_inicial";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/explorar")
    public String explorar() {
        return "explorar";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/minhas_denuncias")
    public String telaDenuncia() {
        return "tela_denuncia";
    }

    @GetMapping("/tela_conclusao")
    public String telaConclusao() {
        return "tela_conclusao";
    }

    @GetMapping("/tela_acompanhamento")
    public String telaAcompanhamento() {
        return "tela_acompanhamento";
    }
} 