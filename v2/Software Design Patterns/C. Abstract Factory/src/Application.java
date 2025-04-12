public class Application {
    Button button;
    Checkbox checkbox;

    public Application(ProductFactory productFactory) {
        this.button = productFactory.createButton();
        this.checkbox = productFactory.createCheckbox();
    }

    public void test() {
        this.button.click();
        this.checkbox.click();
    }
}
