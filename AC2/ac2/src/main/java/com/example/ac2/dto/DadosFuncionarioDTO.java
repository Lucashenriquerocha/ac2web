package com.example.ac2.dto;

import com.example.ac2.models.Projeto;

import java.util.List;

public class DadosFuncionarioDTO {

    private Integer id;
    private String nome;
    private List<Projeto> projetos;

    public DadosFuncionarioDTO() {
    }

    public DadosFuncionarioDTO(Integer id, String nome, List<Projeto> projetos) {
        this.id = id;
        this.nome = nome;
        this.projetos = projetos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}

