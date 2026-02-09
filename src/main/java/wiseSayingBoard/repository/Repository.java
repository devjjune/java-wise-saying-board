package wiseSayingBoard.repository;

import wiseSayingBoard.domain.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private int lastId = 0;

    public void save(WiseSaying wiseSaying) {
        wiseSayingList.add(wiseSaying);
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
