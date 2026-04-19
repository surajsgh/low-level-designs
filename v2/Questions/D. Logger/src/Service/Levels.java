package Service;

public enum Levels {
    DEBUG(1), INFO(2), WARNING(3), ERROR(4), FATAL(5);

    private int priority;

    Levels(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
