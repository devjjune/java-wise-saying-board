package wiseSayingBoard;

import wiseSayingBoard.controller.WiseSayingController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner);
        wiseSayingController.run();

        scanner.close();
    }
}
