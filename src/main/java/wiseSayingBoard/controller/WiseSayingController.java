package wiseSayingBoard.controller;

import wiseSayingBoard.Rq;
import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.service.WiseSayingService;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner scanner;
    private WiseSayingService wiseSayingService = new WiseSayingService();

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void actionWrite() {
        String content = InputView.readContent(this.scanner);
        String author = InputView.readAuthor(this.scanner);
        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        OutputView.printAddMessage(wiseSaying.getId());
    }

    public void actionShowList() {
        OutputView.printListBar();
        List<WiseSaying> reversedList = wiseSayingService.showList();
        for (WiseSaying ws : reversedList) {
            OutputView.printList(ws);
        }
    }

    public void actionDelete(Rq rq) {
        int targetId = rq.getParamAsInt("id", -1);
        if (targetId == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = wiseSayingService.findById(targetId);
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        wiseSayingService.delete(foundWiseSaying);
        OutputView.printDeleteMessage(targetId);
    }

    public void actionModify(Rq rq) {
        int targetId = rq.getParamAsInt("id", -1);
        if (targetId == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = wiseSayingService.findById(targetId);
        if (foundWiseSaying == null) {
            OutputView.printNotFoundMessage(targetId);
            return;
        }
        OutputView.printOriginalContent(foundWiseSaying.getContent());
        String newContent = InputView.readContent(this.scanner);

        OutputView.printOriginalAuthor(foundWiseSaying.getAuthor());
        String newAuthor = InputView.readAuthor(this.scanner);

        wiseSayingService.modify(foundWiseSaying, newContent, newAuthor);
        OutputView.printModifyMessage(targetId);
    }
}
