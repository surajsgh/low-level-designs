package Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LogMessage {
    private LocalDateTime currentTimeStamp;
    private Levels level;
    private String message;

    public LogMessage(Levels level, String message) {
        this.currentTimeStamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
    }

    public String format() {
        return this.currentTimeStamp + "[" + this.level + "]" + this.message;
    }

    public Levels getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
