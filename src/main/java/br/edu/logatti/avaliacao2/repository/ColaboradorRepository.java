package br.edu.logatti.avaliacao2.repository;

import br.edu.logatti.avaliacao2.model.Colaborador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {
}