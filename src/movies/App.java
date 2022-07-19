package movies;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String API_KEY = args[0];
        String url = "https://imdb-api.com/en/API/Top250Movies/" + API_KEY;

        URI endpoint = URI.create(url);
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(endpoint).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

        // Extrair apenas os dados que interessam (título, poster, classificação, ano)
        List<Map<String, String>> movies = JsonParser.parse(body);

        // Exibir e manibular os dados
        movies.forEach(m -> {
            System.out.println(m);
        });
    }
}