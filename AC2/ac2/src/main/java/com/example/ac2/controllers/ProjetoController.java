package com.example.ac2.controllers;

import com.example.ac2.dto.ProjetoDTO;
import com.example.ac2.dto.DadosProjetoDTO;
import com.example.ac2.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.adicionarProjeto(projetoDTO);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/{id}")
    public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        DadosProjetoDTO projeto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(projeto);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionarioAoProjeto(idProjeto, idFuncionario);
        return ResponseEntity.ok().build();
    }
}

