package com.example.ac2.controllers;

import com.example.ac2.dto.FuncionarioDTO;
import com.example.ac2.dto.DadosFuncionarioDTO;
import com.example.ac2.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionarFuncionario(funcionarioDTO);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}/projetos")
    public ResponseEntity<List<DadosFuncionarioDTO>> buscarProjetos(@PathVariable Integer id) {
        List<DadosFuncionarioDTO> projetos = funcionarioService.buscarProjetosPorFuncionario(id);
        return ResponseEntity.ok(projetos);
    }
}
