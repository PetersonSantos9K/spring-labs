package com.petersonsantos.projeto_teste_springboot.controller;


import com.petersonsantos.projeto_teste_springboot.service.MensagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensagemService service;

    public MensagemController(MensagemService service){
        this.service = service;
    }

    @GetMapping("/mensagem")
    public String obterMensagem() {
        return service.obterMensagem();
    }



}


