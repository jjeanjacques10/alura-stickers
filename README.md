## Imersão Java Alura

Projeto da Imersão Java da Alura.

Site da Imersão: <https://www.alura.com.br/imersao-java>

## Estrutura do projeto

- `src`: Arquivos de código fonte
  - `movies`: Código fonte do App que chama o IMDb API
  - `stickers`: Código fonte do App que gera os stickers

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

<img src="src\stickers\images\output\movie-file.png" width="200" alt="Sticker"/>

---
Developed by [@jjeanjacques10](https://twitter.com/jjeanjacques10)
