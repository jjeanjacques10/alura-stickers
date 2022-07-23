package br.com.alura.linguagensapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.linguagensapi.entity.Linguagem;
import br.com.alura.linguagensapi.repository.LinguagemRepository;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping("/{id}")
    public Linguagem voteLinguagem(@PathVariable String id) {
        var linguagem = repository.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found - " + id));

        linguagem.setRanking(linguagem.getRanking() + 1);
        return repository.save(linguagem);
    }

}
