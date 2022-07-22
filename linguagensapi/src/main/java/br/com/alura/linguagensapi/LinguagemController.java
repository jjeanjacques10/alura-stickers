package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    List<Linguagem> linguagems = List.of(
            new Linguagem("Java",
                    "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_128x128.png",
                    1),
            new Linguagem("Python",
                    "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_128x128.png",
                    2),
            new Linguagem("JavaScript",
                    "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_128x128.png",
                    3));

    @GetMapping(value = "/linguagems")
    public List<Linguagem> getMethodName() {
        return linguagems;
    }

}
