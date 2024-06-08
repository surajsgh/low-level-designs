public class ExternalButton {
    ExternalButtonDispatcher buttonDispatcher;

    public ExternalButton() {
        this.buttonDispatcher = new ExternalButtonDispatcher();
    }

    public void pressExternalButton(Direction dir, int currentFloor, int id) {
        buttonDispatcher.submitExternalRequest(currentFloor, id);
    }
}
