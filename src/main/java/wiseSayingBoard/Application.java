package wiseSayingBoard;

import wiseSayingBoard.controller.Controller;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller(scanner);
        controller.run();

        scanner.close();
    }
}
