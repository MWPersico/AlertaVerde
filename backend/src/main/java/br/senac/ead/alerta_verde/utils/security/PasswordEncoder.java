package br.senac.ead.alerta_verde.utils.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
}
