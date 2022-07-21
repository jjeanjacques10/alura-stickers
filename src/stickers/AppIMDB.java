package stickers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import movies.JsonParser;

public class AppIMDB {
    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        URI endpoint = URI.create(url);
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(endpoint).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        List<Map<String, String>> movies = JsonParser.parse(body);

        StickerGenerator stickerGenerator = new StickerGenerator();

        movies.forEach(m -> {
            String title = m.get("fullTitle");
            String image = m.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            try {
                System.out.println(title + " - " + image);
                stickerGenerator.createFromUrl(image, title);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
