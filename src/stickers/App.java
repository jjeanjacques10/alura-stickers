package stickers;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        StickerGenerator stickerGenerator = new StickerGenerator();
        try {
            stickerGenerator.createFromFile("src/stickers/images/movie.jpg", "movie-file");
            stickerGenerator.createFromUrl(
                    "https://m.media-amazon.com/images/M/MV5BZDJmODA5NGEtZmU1ZC00NDRkLWJkYmEtYmUxYzY0NmY4MTYwXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_FMjpg_UX756_.jpg",
                    "movie-url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
