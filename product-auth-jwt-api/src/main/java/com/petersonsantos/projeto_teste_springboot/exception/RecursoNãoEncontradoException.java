package com.petersonsantos.projeto_teste_springboot.exception;

public class RecursoNãoEncontradoException extends RuntimeException {

    public RecursoNãoEncontradoException(String message) {
        super(message);
    }
}
