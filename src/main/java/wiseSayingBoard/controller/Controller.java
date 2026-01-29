package wiseSayingBoard.controller;

import wiseSayingBoard.domain.WiseSaying;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Scanner scanner;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        OutputView.printStartMessage();
        int id = 0;

        while (true) {
            String command = InputView.readCommand(this.scanner);

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                id++;
                String content = InputView.readContent(this.scanner);
                String author = InputView.readAuthor(this.scanner);

                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayingList.add(wiseSaying);
                OutputView.printAddMessage(id);

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (WiseSaying i : wiseSayingList) {
                    OutputView.printList(i.getId(), i.getAuthor(), i.getContent());
                }
            }
        }
    }
}
