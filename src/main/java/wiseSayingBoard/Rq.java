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
        // ?가 없는 명령어일 경우 예외 처리
        String queryString = commandBits.length > 1 ? commandBits[1] : "";

        // 다중 쿼리일 경우 분석 로직
        String[] queryBits = queryString.split("&");
        for (String queryBit : queryBits) {
            String[] bits = queryBit.split("=", 2); // id=1
            String key = bits[0]; // id
            String value = bits.length > 1 ? bits[1] : ""; // 1

            paramMap.put(key, value);
        }
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key, String defaultValue) {
        if (paramMap.containsKey(key)) {
            return paramMap.get(key);
        }
        return defaultValue;
    }

    public int getParamAsInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(paramMap.get(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
