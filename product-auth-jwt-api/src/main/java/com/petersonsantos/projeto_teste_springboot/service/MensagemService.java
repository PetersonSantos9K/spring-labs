package com.petersonsantos.projeto_teste_springboot.service;

import com.petersonsantos.projeto_teste_springboot.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository repository){
        this.mensagemRepository = repository;
    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }



}
