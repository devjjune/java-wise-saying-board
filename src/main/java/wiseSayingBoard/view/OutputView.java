package wiseSayingBoard.view;

import wiseSayingBoard.domain.WiseSaying;

import java.time.format.DateTimeFormatter;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("== 명언 앱 ==");
    }

    public static void printAddMessage(int id) {
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public static void printListBar() {
        System.out.println("번호 / 작가 / 명언 / 작성일 / 수정일");
        System.out.println("----------------------------------------");
    }

    public static void printList(WiseSaying ws) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 H시 mm분 ss초");
        System.out.println("%d / %s / %s / %s / %s".formatted(ws.getId(), ws.getAuthor(), ws.getContent(), ws.getCreatedDate(), ws.getModifiedDate()) );
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
