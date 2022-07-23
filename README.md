## Imersão Java Alura

Projeto da semana Imersão Java da Alura.

Site da Imersão: <https://www.alura.com.br/imersao-java>

## Estrutura do projeto

- `src`: Arquivos de código fonte
  - `movies`: Código fonte do App que chama o IMDb API
  - `stickers`: Código fonte do App que gera os stickers
  - `stikcersrefactored`: Código fonte do App que gera os stickers refatorado na aula 3
- `linguagensapi`: Projeto Spring Boot para listar as linguagens de programação

## Aula 1 - IMDb API

Site de consulta de filmes e séries. Estamos utilizando a API pública deles para obter os dados.

URL da API: <https://imdb-api.com/>

- GET <https://imdb-api.com/en/API/Top250Movies/>

## Aula 2 - Gerando Figurinhas para WhatsApp

Utilizando bibliotecas padrões do Java para manipulação de imagens.

``` java
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
```

**Exemplo de Sticker**

<center>
  <img src="src\stickers\images\output\movie-file.png" width="200" alt="Sticker"/>
</center>

## Aula 3 - Ligando as pontas, refatorando o código

Utilizando melhores práticas de programação para o código desenvolvido na aula 2. Adicionando figurinhas da Nasa.

**Exemplo de Sticker NASA**

<center>
  <img src="src\stickersrefactored\images\output\The Averted Side Of The Moon.png" width="200" alt="Sticker"/>
</center>

Alteração da Classe `Content` para um `record` do Java.

``` java
public class Content {

    private final String title;
    private final String imageUrl;

    public Content(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
```

Nova versão como um [record](https://www.guiadojava.com.br/2021/04/java-records.html).

``` java
public record Content(String title, String imageUrl) {}
```

## Aula 4

Criando a API utilizando [Spring](https://spring.io/) e [MongoDB](https://cloud.mongodb.com/). Para realizar a conexão com o banco de dados MongoDb é necessário utilizar a String de conexão abaixo.

``` application.properties
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@cluster0.ha1bu.mongodb.net/?retryWrites=true&w=majority
spring.data.mongodb.database=aluradb
```

- GET <http://localhost:8080/linguagens>
- POST <http://localhost:8080/linguagens>
- GET <http://localhost:8080/linguagens/{id}>
- PUT <http://localhost:8080/linguagens/{id}>
- DELETE <http://localhost:8080/linguagens/{id}>

Exemplo de retorno:

``` json
{
    "id": "62d9fb6ecf2973da6f041737",
    "title": "Java",
    "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_128x128.png",
    "ranking": 1
},
{
    "id": "62d9fb9dcf2973da6f041738",
    "title": "Python",
    "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_128x128.png",
    "ranking": 2
},
{
    "id": "62d9fbb5cf2973da6f041739",
    "title": "JavaScript",
    "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_128x128.png",
    "ranking": 3
}
```

---
Developed by [@jjeanjacques10](https://twitter.com/jjeanjacques10)
