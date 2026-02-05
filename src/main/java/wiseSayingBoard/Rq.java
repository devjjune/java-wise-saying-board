package wiseSayingBoard;

public class Rq {
    private String actionName;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);
        this.actionName = commandBits[0];
    }

    public String getActionName() {
        return actionName;
    }
}
