
package com.vidaemgotas.service;

import com.vidaemgotas.model.Doador;
import com.vidaemgotas.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {
    @Autowired
    private DoadorRepository repository;

    public List<Doador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Doador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Doador salvar(Doador doador) {
        return repository.save(doador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
