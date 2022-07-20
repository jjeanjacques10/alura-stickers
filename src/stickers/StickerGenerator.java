package stickers;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickerGenerator {

    public void createFromFile(String path, String nameFile) throws IOException {
        // Leitura da imagem
        BufferedImage image = ImageIO.read(new File(path));
        this.create(image, nameFile);
    }

    public void createFromUrl(String url, String nameFile) throws IOException {
        // Leitura da imagem
        BufferedImage image = ImageIO.read(new URL(url));
        this.create(image, nameFile);
    }

    private void create(BufferedImage image, String nameFile) throws IOException {
        // Cria nova image em memória com transparência e com tamanho novo
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        // Escrever uma frase na nova imagem
        graphics.setColor(Color.GREEN);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        graphics.drawString("Doutor Estranho", 100, newHeight - 100);

        // Escreve
        ImageIO.write(newImage, "png", new File("src/stickers/images/output/" + nameFile + ".png"));
    }

}
