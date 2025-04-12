public abstract class Dialog {
    public abstract Button createButton();

    public void render() {
        Button button = createButton();
//        button.onClick();
        button.render();
    }
}
