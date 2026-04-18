package Services;

public class AdminService {
    private Catalogue catalogue;

    public AdminService(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public void refill(int slotId, int quantity) {
        catalogue.getSlot(slotId).restock(quantity);
    }
}
