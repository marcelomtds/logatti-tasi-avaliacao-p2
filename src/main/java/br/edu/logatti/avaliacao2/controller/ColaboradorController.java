package br.edu.logatti.avaliacao2.controller;

import br.edu.logatti.avaliacao2.constant.Constant;
import br.edu.logatti.avaliacao2.model.Colaborador;
import br.edu.logatti.avaliacao2.model.request.ColaboradorRequest;
import br.edu.logatti.avaliacao2.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.COLABORADOR_API)
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @PostMapping
    public ResponseEntity save(@RequestBody final ColaboradorRequest request) {
        service.sendRabbit(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Colaborador> update(@RequestBody final ColaboradorRequest request) {
        return ResponseEntity.ok().body(service.save(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Colaborador>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}