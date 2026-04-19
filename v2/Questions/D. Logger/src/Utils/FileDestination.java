package Utils;

import Service.LogMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDestination implements DestinationStrategy{
    private String fileName;

    public FileDestination(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public synchronized void print(LogMessage logMessage){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.fileName);
            fileWriter.write(logMessage.format());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
