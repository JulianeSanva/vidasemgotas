
package com.vidaemgotas.controller;

import com.vidaemgotas.model.Doador;
import com.vidaemgotas.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doadores")
@CrossOrigin(origins = "*")
public class DoadorController {

    @Autowired
    private DoadorService service;

    @GetMapping
    public List<Doador> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Doador buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Doador salvar(@RequestBody Doador doador) {
        return service.salvar(doador);
    }

    @PutMapping("/{id}")
    public Doador atualizar(@PathVariable Long id, @RequestBody Doador doador) {
        doador.setId(id);
        return service.salvar(doador);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
