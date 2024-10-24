package com.example.ac2.dto;

public class FuncionarioDTO {

    private String nome;

    public FuncionarioDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FuncionarioDTO(String nome) {
        this.nome = nome;
    }
}

