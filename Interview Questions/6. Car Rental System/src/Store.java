public class Store {
    int id;
    int counter = 0;
    Inventory inventory;

    public Store(Inventory inventory) {
        this.counter += 1;
        this.id = this.counter;
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
