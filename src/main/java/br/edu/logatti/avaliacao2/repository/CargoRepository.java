package br.edu.logatti.avaliacao2.repository;

import br.edu.logatti.avaliacao2.model.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends MongoRepository<Cargo, String> {
}