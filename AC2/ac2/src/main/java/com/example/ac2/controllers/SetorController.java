package com.example.ac2.controllers;


import com.example.ac2.dto.SetorDTO;
import com.example.ac2.dto.DadosSetorDTO;
import com.example.ac2.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody SetorDTO setorDTO) {
        setorService.adicionarSetor(setorDTO);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private SetorService setorService;

    @GetMapping("/{id}")
    public ResponseEntity<DadosSetorDTO> buscarSetorPorId(@PathVariable Integer id) {
        DadosSetorDTO setor = setorService.buscarSetorPorId(id);
        return ResponseEntity.ok(setor);
    }

    @GetMapping
    public ResponseEntity<List<DadosSetorDTO>> listarSetoresComFuncionarios() {
        List<DadosSetorDTO> setores = setorService.listarSetoresComFuncionarios();
        return ResponseEntity.ok(setores);
    }
}

