package Services;

import Exceptions.InvalidSelectionException;

import java.util.concurrent.ConcurrentHashMap;

public class Catalogue {
    private ConcurrentHashMap<Integer, Slot> products = new ConcurrentHashMap<>();

    public Slot getSlot(int slotId) {
        Slot product = products.get(slotId);
        if (product==null) throw new InvalidSelectionException();
        return product;
    }

    public void addProduct(int catalogueId, Product product, int quantity) {
        products.put(catalogueId, new Slot(product, quantity));
    }
}
