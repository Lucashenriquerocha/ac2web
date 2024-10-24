package com.example.ac2.services;

import com.example.ac2.dto.SetorDTO;
import com.example.ac2.dto.DadosSetorDTO;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.SetorRepository;
import com.example.ac2.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public void adicionarSetor(SetorDTO setorDTO) {
        Setor setor = new Setor(setorDTO.getNome());
        setorRepository.save(setor);
    }

    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor)
            .orElseThrow(() -> new RuntimeException("Setor não encontrado."));
        List<Funcionario> funcionarios = setor.getFuncionarios();
        return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }

    public List<DadosSetorDTO> listarSetoresComFuncionarios() {
        List<Setor> setores = setorRepository.findAll();
        return setores.stream()
            .map(setor -> new DadosSetorDTO(setor.getId(), setor.getNome(), setor.getFuncionarios()))
            .collect(Collectors.toList());
    }
}
