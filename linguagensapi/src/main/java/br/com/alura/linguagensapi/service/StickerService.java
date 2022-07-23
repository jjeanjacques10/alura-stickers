package br.com.alura.linguagensapi.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.linguagensapi.repository.LinguagemRepository;

@Service
public class StickerService {

    @Autowired
    private LinguagemRepository repository;

    public String generate(String idLinguagem) throws IOException {
        var linguagem = repository.getById(idLinguagem)
                .orElseThrow(() -> new IllegalArgumentException("Id not found - " + idLinguagem));

        BufferedImage image = ImageIO.read(new URL(linguagem.getImage()));
        return this.saveImage(image, linguagem.getTitle());
    }

    private String saveImage(BufferedImage image, String nameFile) throws IOException {
        // Cria nova image em memória com transparência e com tamanho novo
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 180;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        // Escrever uma frase na nova imagem
        graphics.setColor(Color.GREEN);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        graphics.drawString(nameFile, 20, newHeight - 100);

        // Escreve
        ImageIO.write(newImage, "png",
                new File("target/stickers-output/" + nameFile + ".png"));

        return Paths.get("target") + "/stickers-output/" + nameFile + ".png";
    }
}
