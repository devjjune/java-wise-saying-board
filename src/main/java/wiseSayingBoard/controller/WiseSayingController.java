package wiseSayingBoard.controller;

import system.SystemController;
import wiseSayingBoard.Rq;
import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private int id;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private SystemController systemController = new SystemController();

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        OutputView.printStartMessage();

        while (true) {
            String command = InputView.readCommand(this.scanner);
            Rq rq = new Rq(command);
            String actionName = rq.getActionName();

            if (actionName.equals("종료")) {
                systemController.exit();
                break;
            }

            if (actionName.equals("등록")) {
                actionWrite();
            } else if (actionName.equals("목록")) {
                actionShowList();
            } else if (actionName.equals("삭제")) {
                actionDelete(rq);
            } else if (actionName.equals("수정")) {
                actionModify(rq);
            }
        }
    }

    private void actionWrite() {
        id++;
        String content = InputView.readContent(this.scanner);
        String author = InputView.readAuthor(this.scanner);

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        OutputView.printAddMessage(id);
    }

    private void actionShowList() {
        OutputView.printListBar();

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayingList.get(i);
            OutputView.printList(ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }

    private void actionDelete(Rq rq) {
        // == 입력값 분해 (Parse) ==
        int targetId = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }

        // == wiseSayingList에서 targetId에 해당하는 명언 찾기 ==
        WiseSaying foundWiseSaying = findByTargetId(targetId);

        // == 리스트에서 명언 삭제 ==
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        wiseSayingList.remove(foundWiseSaying);
        OutputView.printDeleteMessage(targetId);
    }

    private void actionModify(Rq rq) {
        // == 입력값 분해 (Parse) ==
        int targetId = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }

        // == wiseSayingList에서 targetId에 해당하는 명언 찾기 ==
        WiseSaying foundWiseSaying = findByTargetId(targetId);

        // == 리스트에서 명언 수정 ==
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        OutputView.printOriginalContent(foundWiseSaying.getContent());
        String newContent = InputView.readContent(this.scanner);
        foundWiseSaying.setContent(newContent);

        OutputView.printOriginalAuthor(foundWiseSaying.getAuthor());
        String newAuthor = InputView.readAuthor(this.scanner);
        foundWiseSaying.setAuthor(newAuthor);

        OutputView.printModifyMessage(targetId);
    }

    private WiseSaying findByTargetId(int targetId) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == targetId)
                .findFirst()
                .orElse(null);
    }
}
