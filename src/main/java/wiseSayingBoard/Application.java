package wiseSayingBoard;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int order = 0;

        while (true) {
            System.out.println("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                order ++;

                System.out.println("명언 : ");
                String wiseSaying = scanner.nextLine();

                System.out.println("작가 : ");
                String author = scanner.nextLine();

                System.out.println(order + "번 명령이 등록되었습니다.");
            }
        }
    }
}
