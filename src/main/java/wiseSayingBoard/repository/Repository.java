package wiseSayingBoard.repository;

import wiseSayingBoard.domain.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) { // 새로운 명언 객체일 때
            lastId++;
            wiseSaying.setId(lastId);
            wiseSayingList.add(wiseSaying);
        }
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return new ArrayList<>(wiseSayingList);
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public WiseSaying findById(int targetId) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == targetId)
                .findFirst()
                .orElse(null);
    }

    public int generateId() {
        return ++lastId;
    }
}
