package wiseSayingBoard;

import wiseSayingBoard.controller.SystemController;
import wiseSayingBoard.controller.WiseSayingController;
import wiseSayingBoard.repository.WiseSayingRepository;
import wiseSayingBoard.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static final Scanner scanner = new Scanner(System.in);
    public static final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static final WiseSayingService wiseSayingService = new WiseSayingService();
    public static final WiseSayingController wiseSayingController = new WiseSayingController(scanner);
    public static final SystemController systemController = new SystemController();
}
