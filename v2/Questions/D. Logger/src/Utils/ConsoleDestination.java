package Utils;

import Service.LogMessage;

public class ConsoleDestination implements DestinationStrategy{
    @Override
    public void print(LogMessage logMessage) {
        System.out.println(logMessage.format());
    }
}
