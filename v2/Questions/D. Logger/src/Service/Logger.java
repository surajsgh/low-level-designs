package Service;

import Configurations.LogConfiguration;
import Utils.DestinationStrategy;

public class Logger {
    private static Logger instance;
    private LogConfiguration logConfiguration;

    private Logger(LogConfiguration logConfiguration) {
        this.logConfiguration = logConfiguration;
    }

    public static synchronized Logger getInstance(LogConfiguration logConfiguration) {
        if (instance==null) {
            instance = new Logger(logConfiguration);
        }
        return instance;
    }

    private void log(Levels level, String message) {
        if (this.logConfiguration.getLogLevel().getPriority() > level.getPriority()) {
            return;
        }

        LogMessage logMessage = new LogMessage(level, message);

        for (DestinationStrategy appender: logConfiguration.getAppenders()) {
            appender.print(logMessage);
        }
    }

    public void info(String message) {
        log(Levels.INFO, message);
    }

    public void debug(String message) {
        log(Levels.DEBUG, message);
    }

    public void error(String message) {
        log(Levels.ERROR, message);
    }
}
