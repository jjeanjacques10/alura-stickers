package br.com.alura.linguagensapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.linguagensapi.entity.Linguagem;
import br.com.alura.linguagensapi.repository.LinguagemRepository;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping
    public List<Linguagem> findAll() {
        Sort sortBy = Sort.by(Order.desc("ranking"));
        return repository.findAll(sortBy);
    }

    @GetMapping("/{id}")
    public Linguagem findById(@PathVariable String id) {
        return repository.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found - " + id));
    }

    @PostMapping
    public Linguagem create(@RequestBody Linguagem linguagem) {
        return repository.save(linguagem);
    }

    @PutMapping("/{id}")
    public Linguagem update(@PathVariable String id, @RequestBody Linguagem linguagemUpdate) {
        var linguagem = repository.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found - " + id));

        linguagem.setTitle(linguagemUpdate.getTitle());
        linguagem.setImage(linguagemUpdate.getImage());
        linguagem.setRanking(linguagemUpdate.getRanking());

        return repository.save(linguagem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
