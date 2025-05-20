
package com.vidaemgotas.controller;

import com.vidaemgotas.model.Instituicao;
import com.vidaemgotas.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicoes")
@CrossOrigin(origins = "*")
public class InstituicaoController {

    @Autowired
    private InstituicaoService service;

    @GetMapping
    public List<Instituicao> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Instituicao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Instituicao salvar(@RequestBody Instituicao instituicao) {
        return service.salvar(instituicao);
    }

    @PutMapping("/{id}")
    public Instituicao atualizar(@PathVariable Long id, @RequestBody Instituicao instituicao) {
        instituicao.setId(id);
        return service.salvar(instituicao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
