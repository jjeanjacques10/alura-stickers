package stickersrefactored.extract;

import java.util.List;

import stickersrefactored.Content;

public interface ContentExtractor {

    List<Content> extract(String json);

}
