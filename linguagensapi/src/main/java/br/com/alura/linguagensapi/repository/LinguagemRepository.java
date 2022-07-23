package br.com.alura.linguagensapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.linguagensapi.entity.Linguagem;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

    Optional<Linguagem> getById(String id);

}
