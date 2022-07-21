package stickersrefactored;

import java.io.IOException;
import java.util.List;

import stickersrefactored.extract.ContentExtractor;
import stickersrefactored.extract.ImdbContentExtractor;
import stickersrefactored.extract.NasaContentExtractor;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2021-10-07&end_date=2021-10-11";
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        var http = new HttpClientSticker();
        String json = http.searchData(url);

        // Content Extractor
        // ContentExtractor extractor = new ImdbContentExtractor(); // IMDB
        ContentExtractor extractor = new NasaContentExtractor(); // Nasa

        List<Content> contents = extractor.extract(json);

        StickerGenerator stickerGenerator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {
            var content = contents.get(i);
            try {
                System.out.println(content.title() + " - " + content.imageUrl());
                stickerGenerator.createFromUrl(content.imageUrl(), content.title());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
