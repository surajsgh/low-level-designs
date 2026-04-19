package Utils;

import Service.LogMessage;

import java.io.IOException;

public interface DestinationStrategy {
    void print(LogMessage logMessage);
}
