package br.edu.logatti.avaliacao2.service;

import br.edu.logatti.avaliacao2.exception.ResourceNotFoundException;
import br.edu.logatti.avaliacao2.model.Cargo;
import br.edu.logatti.avaliacao2.rabbit.producer.CargoProducer;
import br.edu.logatti.avaliacao2.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    @Autowired
    private CargoProducer cargoProducer;

    public void sendRabbit(final Cargo cliente) {
        cargoProducer.send(cliente);
    }

    public Cargo save(final Cargo cliente) {
        return repository.save(cliente);
    }

    public List<Cargo> findAll() {
        return repository.findAll();
    }

    public Optional<Cargo> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Cargo.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}
