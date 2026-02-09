package wiseSayingBoard.service;

import wiseSayingBoard.domain.WiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private int id;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++id, content, author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> showList() {
        List<WiseSaying> sortedList = new ArrayList<>(wiseSayingList);
        Collections.reverse(sortedList);
        return sortedList;
    }

    public void delete(WiseSaying foundWiseSaying) {
        wiseSayingList.remove(foundWiseSaying);
    }

    public void modify(WiseSaying foundWiseSaying, String newContent, String newAuthor) {
        foundWiseSaying.setContent(newContent);
        foundWiseSaying.setAuthor(newAuthor);
    }

    public WiseSaying findByTargetId(int targetId) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == targetId)
                .findFirst()
                .orElse(null);
    }

    public int getId() {
        return id;
    }
}
