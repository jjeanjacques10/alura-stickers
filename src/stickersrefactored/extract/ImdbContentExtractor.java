package stickersrefactored.extract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import stickersrefactored.Content;
import stickersrefactored.JsonParser;

public class ImdbContentExtractor implements ContentExtractor {

    @Override
    public List<Content> extract(String json) {
        List<Map<String, String>> items = JsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        items.forEach(item -> {
            String title = item.get("title");
            String imageUrl = item.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            var content = new Content(title, imageUrl);
            contents.add(content);
        });

        return contents;
    }

}
