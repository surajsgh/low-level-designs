public class Main {
    private static Dialog dialog;

    public static void main(String[] args) {
        initialize("Window");
        runBusinessLogic();
    }

    private static void initialize(String input) {
        if (input.equals(Input.Html.name())) {
            dialog = new HtmlDialog();
        }
        else if (input.equals(Input.Window.name())) {
            dialog = new WindowDialog();
        }
        else {
            dialog = null;
        }
    }

    private static void runBusinessLogic() {
        dialog.render();
    }
}