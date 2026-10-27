package com.petersonsantos.testes_unitarios.dtos;

public record UserCreateDTO(
        String name,
        String email,
        String password
) {
}
