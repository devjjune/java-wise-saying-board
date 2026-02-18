package wiseSayingBoard;

import wiseSayingBoard.controller.SystemController;
import wiseSayingBoard.controller.WiseSayingController;
import wiseSayingBoard.view.InputView;
import wiseSayingBoard.view.OutputView;

import java.util.Scanner;

public class Application {
    private Scanner scanner = new Scanner(System.in);
    private WiseSayingController wiseSayingController = new WiseSayingController(scanner);
    private SystemController systemController = new SystemController();

    public void run() {
        OutputView.printStartMessage();

        while (true) {
            String command = InputView.readCommand(this.scanner);
            Rq rq = new Rq(command);
            String actionName = rq.getActionName();

            if (actionName.equals("종료")) {
                systemController.exit();
                scanner.close();
                break;
            }

            if (actionName.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (actionName.equals("목록")) {
                wiseSayingController.actionShowList();
            } else if (actionName.equals("삭제")) {
                wiseSayingController.actionDelete(rq);
            } else if (actionName.equals("수정")) {
                wiseSayingController.actionModify(rq);
            }
        }
    }
}
