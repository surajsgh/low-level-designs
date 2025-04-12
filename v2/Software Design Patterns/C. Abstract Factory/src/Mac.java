public class Mac implements ProductFactory{
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }
}
