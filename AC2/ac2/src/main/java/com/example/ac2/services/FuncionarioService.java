package com.example.ac2.services;

import com.example.ac2.dto.FuncionarioDTO;
import com.example.ac2.dto.DadosFuncionarioDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    
    public void adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO.getNome());
        funcionarioRepository.save(funcionario);
    }

    
    public List<DadosFuncionarioDTO> buscarProjetosPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        List<Projeto> projetos = funcionario.getProjetos();
        return List.of(new DadosFuncionarioDTO(funcionario.getId(), funcionario.getNome(), projetos));
    }
}
