public class DebugLog extends LogProcessor {
    public DebugLog(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int level, String message) {
        if (level==DEBUG) {
            System.out.println("DEBUGGING: " + message);
        }
        else {
            super.log(level, message);
        }
    }
}
