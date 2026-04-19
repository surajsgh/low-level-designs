package Configurations;

import Service.Levels;
import Utils.DestinationStrategy;

import java.util.ArrayList;
import java.util.List;

public class LogConfiguration {
    private Levels logLevel;
    private List<DestinationStrategy> appenders;

    public LogConfiguration(Levels logLevel) {
        this.logLevel = logLevel;
        appenders = new ArrayList<>();
    }

    public void addAppenders(DestinationStrategy destinationStrategy) {
        this.appenders.add(destinationStrategy);
    }

    public Levels getLogLevel() {
        return logLevel;
    }

    public List<DestinationStrategy> getAppenders() {
        return appenders;
    }
}
