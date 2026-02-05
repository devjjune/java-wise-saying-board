package wiseSayingBoard;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionName;
    private Map<String, String> paramMap;

    public Rq(String command) {
        paramMap = new HashMap<>();

        String[] commandBits = command.split("\\?", 2);
        this.actionName = commandBits[0];
        String queryString = commandBits[1]; // id=1

        String[] queryBits = queryString.split("=", 2);
        String key = queryBits[0]; // id
        String value = queryBits[1]; // 1

        paramMap.put(key, value);
    }

    public String getActionName() {
        return actionName;
    }

    public int getParamAsInt(String key) {
        return Integer.parseInt(paramMap.get(key));
    }
}
