package wiseSayingBoard.controller;

import system.SystemController;
import wiseSayingBoard.Rq;
import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.repository.Repository;
import wiseSayingBoard.service.Service;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private SystemController systemController = new SystemController();
    private Service service = new Service();
    private Repository repo = new Repository();

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
        String content = InputView.readContent(this.scanner);
        String author = InputView.readAuthor(this.scanner);
        WiseSaying wiseSaying = service.write(content, author);
        OutputView.printAddMessage(wiseSaying.getId());
    }

    private void actionShowList() {
        OutputView.printListBar();
        List<WiseSaying> reversedList = service.showList();
        for (WiseSaying ws : reversedList) {
            OutputView.printList(ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }

    private void actionDelete(Rq rq) {
        int targetId = rq.getParamAsInt("id", -1);
        if (targetId == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = repo.findById(targetId);
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        service.delete(foundWiseSaying);
        OutputView.printDeleteMessage(targetId);
    }

    private void actionModify(Rq rq) {
        int targetId = rq.getParamAsInt("id", -1);
        if (targetId == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = repo.findByTargetId(targetId);
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        OutputView.printOriginalContent(foundWiseSaying.getContent());
        String newContent = InputView.readContent(this.scanner);

        OutputView.printOriginalAuthor(foundWiseSaying.getAuthor());
        String newAuthor = InputView.readAuthor(this.scanner);

        service.modify(foundWiseSaying, newContent, newAuthor);
        OutputView.printModifyMessage(targetId);
    }
}
