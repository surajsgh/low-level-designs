public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogger(new DebugLog(new ErrorLogger(null)));
        logProcessor.log(LogProcessor.INFO, "Info found!");
        logProcessor.log(LogProcessor.DEBUG, "Let's start debugging");
        logProcessor.log(LogProcessor.ERROR, "Oops! something went wrong...");
    }
}