package wiseSayingBoard.service;

import wiseSayingBoard.AppContext;
import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.repository.WiseSayingRepository;

import java.util.Collections;
import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository repo = AppContext.wiseSayingRepository;

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSaying = repo.save(wiseSaying);
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

        repo.save(foundWiseSaying);
    }

    public WiseSaying findById(int targetId) {
        return repo.findById(targetId);
    }
}
