class Logger {
    private static Logger logger;

    private Logger() {

    }

    public static Logger getInstance() {
        if (logger==null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Test");
    }
}