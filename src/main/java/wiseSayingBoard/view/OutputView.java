package wiseSayingBoard.view;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("== 명언 앱 ==");
    }

    public static void printAddMessage(int id) {
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public static void printListBar() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
    }

    public static void printList(int id, String author, String content) {
        System.out.println(id + " / " + author + " / " + content);
    }

    public static void printDeleteMessage(int targetId) {
        System.out.println(targetId + "번 명언이 삭제되었습니다.");
    }

    public static void printNotFoundMessage(int targetId) {
        System.out.println(targetId + "번 명언은 존재하지 않습니다.");
    }

    public static void printOriginalContent(String content) {
        System.out.println("명언(기존) : " + content);
    }

    public static void printOriginalAuthor(String author) {
        System.out.println("작가(기존) : " + author);
    }

    public static void printModifyMessage(int targetId) {
        System.out.println(targetId + "번 명언이 수정되었습니다.");
    }
}
