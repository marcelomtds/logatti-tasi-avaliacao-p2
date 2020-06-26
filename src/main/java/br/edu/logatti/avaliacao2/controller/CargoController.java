package br.edu.logatti.avaliacao2.controller;

import br.edu.logatti.avaliacao2.constant.Constant;
import br.edu.logatti.avaliacao2.model.Cargo;
import br.edu.logatti.avaliacao2.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.CARGO_API)
public class CargoController {

    @Autowired
    private CargoService service;

    @PostMapping
    public ResponseEntity save(@RequestBody final Cargo cargo) {
        service.sendRabbit(cargo);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Cargo> update(@RequestBody final Cargo cargo) {
        return ResponseEntity.ok().body(service.save(cargo));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cargo>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}