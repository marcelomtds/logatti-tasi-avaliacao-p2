package br.edu.logatti.avaliacao2.service;

import br.edu.logatti.avaliacao2.exception.ResourceNotFoundException;
import br.edu.logatti.avaliacao2.model.Colaborador;
import br.edu.logatti.avaliacao2.model.request.ColaboradorRequest;
import br.edu.logatti.avaliacao2.rabbit.producer.ColaboradorProducer;
import br.edu.logatti.avaliacao2.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private ColaboradorProducer colaboradorProducer;

    public void sendRabbit(final ColaboradorRequest request) {
        colaboradorProducer.send(request);
    }

    public Colaborador save(final ColaboradorRequest request) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(request.getId());
        colaborador.setNome(request.getNome());
        colaborador.setTelefone(request.getTelefone());
        colaborador.setCpf(request.getCpf());
        colaborador.setCargo(cargoService.findById(request.getCargoId()).get());
        return repository.save(colaborador);
    }

    public List<Colaborador> findAll() {
        return repository.findAll();
    }

    public Optional<Colaborador> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Colaborador.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}