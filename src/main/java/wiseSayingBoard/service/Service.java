package wiseSayingBoard.service;

import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.repository.Repository;

import java.util.Collections;
import java.util.List;

public class Service {
    private Repository repo = new Repository();

    public WiseSaying write(String content, String author) {
        int id = repo.generateId();
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        repo.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> showList() {
        List<WiseSaying> sortedList = repo.findAll();
        Collections.reverse(sortedList);
        return sortedList;
    }

    public void delete(WiseSaying foundWiseSaying) {
        repo.delete(foundWiseSaying);
    }

    public void modify(WiseSaying foundWiseSaying, String newContent, String newAuthor) {
        foundWiseSaying.setContent(newContent);
        foundWiseSaying.setAuthor(newAuthor);
    }
}
