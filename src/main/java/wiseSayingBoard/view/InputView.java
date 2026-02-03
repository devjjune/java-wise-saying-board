package wiseSayingBoard.view;

import java.util.Scanner;

public class InputView {
    public static String readCommand(Scanner scanner) {
        System.out.println("명령) ");
        String command = scanner.nextLine();

        return command;
    }

    public static String readContent(Scanner scanner) {
        System.out.println("명언 : ");
        String content = scanner.nextLine();

        return content;
    }

    public static String readAuthor(Scanner scanner) {
        System.out.println("작가 : ");
        String author = scanner.nextLine();

        return author;
    }

    public static String readNewContent(Scanner scanner) {
        System.out.println("명언 : ");
        String newContent = scanner.nextLine();

        return newContent;
    }

    public static String readNewAuthor(Scanner scanner) {
        System.out.println("작가 : ");
        String newAuthor = scanner.nextLine();

        return newAuthor;
    }
}
