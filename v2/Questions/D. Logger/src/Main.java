import Configurations.LogConfiguration;
import Service.Levels;
import Service.Logger;
import Utils.ConsoleDestination;
import Utils.DestinationStrategy;
import Utils.FileDestination;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LogConfiguration logConfiguration = new LogConfiguration(Levels.INFO);
        logConfiguration.addAppenders(new FileDestination("./test.txt"));
        logConfiguration.addAppenders(new ConsoleDestination());

        Logger logger = Logger.getInstance(logConfiguration);
        logger.info("Info test");
        logger.error("Error test");
    }
}