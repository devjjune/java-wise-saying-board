package wiseSayingBoard;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String command = scanner.next();

            if (command.equals("종료")) {
                break;
            }
        }
    }
}
