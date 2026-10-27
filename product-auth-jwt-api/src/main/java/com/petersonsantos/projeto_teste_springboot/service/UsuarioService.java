package com.petersonsantos.projeto_teste_springboot.service;

import com.petersonsantos.projeto_teste_springboot.exception.RecursoNãoEncontradoException;
import com.petersonsantos.projeto_teste_springboot.model.Usuario;
import com.petersonsantos.projeto_teste_springboot.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String username, String password){
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return repository.findByUsername(username);
    }
}
