public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.getEventManager().subscribe("open", new LogSubscriber("Log/to/file/tmp.txt"));
        editor.getEventManager().subscribe("save", new EmailSubscriber("abc@test.com"));

        try {
            editor.open("test");
            editor.close("test");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}