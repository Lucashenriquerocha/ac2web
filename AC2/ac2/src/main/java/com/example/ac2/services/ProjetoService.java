package com.example.ac2.services;

import com.example.ac2.dto.ProjetoDTO;
import com.example.ac2.dto.DadosProjetoDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(projetoDTO.getDescricao(), projetoDTO.getDataInicio(), projetoDTO.getDataFim());
        projetoRepository.save(projeto);
    }

    public DadosProjetoDTO buscarProjetoPorId(Integer idProjeto) {
        Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado."));
        List<Funcionario> funcionarios = projeto.getFuncionarios();
        return new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), funcionarios);
    }

    public void vincularFuncionarioAoProjeto(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado."));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    public List<DadosProjetoDTO> buscarProjetosPorDatas(LocalDate dataInicio, LocalDate dataFim) {
    List<Projeto> projetos = projetoRepository.procuraProjetosEntreDatas(dataInicio, dataFim);
    return projetos.stream()
        .map(projeto -> new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), projeto.getFuncionarios()))
        .toList();
}
}
