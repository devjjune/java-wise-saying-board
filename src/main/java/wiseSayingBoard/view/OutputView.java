package wiseSayingBoard.view;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("== 명언 앱 ==");
    }

    public static void printAddMessage(int id) {
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public static void pringListBar() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
    }

    public static void printList(int id, String author, String content) {
        System.out.println(id + " / " + author + " / " + content);
    }
}
