
package com.vidaemgotas.service;

import com.vidaemgotas.model.Instituicao;
import com.vidaemgotas.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {
    @Autowired
    private InstituicaoRepository repository;

    public List<Instituicao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Instituicao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Instituicao salvar(Instituicao instituicao) {
        return repository.save(instituicao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
