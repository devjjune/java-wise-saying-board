package wiseSayingBoard.controller;

import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Controller {
    private final Scanner scanner;
    private int id;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        OutputView.printStartMessage();

        while (true) {
            String command = InputView.readCommand(this.scanner);

            if (command.equals("종료")) break;

            if (command.equals("등록")) {
                actionWrite();
            } else if (command.equals("목록")) {
                actionShowList();
            } else if (command.startsWith("삭제?")) {
                actionDelete(command);
            } else if (command.startsWith("수정?")) {
                actionModify(command);
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

    private void actionDelete(String command) {
        // == 입력값 분해 (Parse) ==
        int targetId = parseIdFromCommand(command);

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

    private void actionModify(String command) {
        // == 입력값 분해 (Parse) ==
        int targetId = parseIdFromCommand(command);

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

    private int parseIdFromCommand(String command) {
        String[] commandBits = command.split("\\?", 2);
        String actionName = commandBits[0];
        String queryString = commandBits[1];

        String[] queryBits = queryString.split("=", 2);
        String paramName = queryBits[0];
        int targetId = Integer.parseInt(queryBits[1]);

        return targetId;
    }

    private WiseSaying findByTargetId(int targetId) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == targetId)
                .findFirst()
                .orElse(null);
    }
}
