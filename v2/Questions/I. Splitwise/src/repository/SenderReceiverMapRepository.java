package repository;

import model.SenderReceiverMap;

import java.util.*;

public class SenderReceiverMapRepository {
    private static Map<String, SenderReceiverMap> senderReceiverMapRecords = new HashMap<>();

    public void save(SenderReceiverMap senderReceiverMap) {
        senderReceiverMapRecords.put(senderReceiverMap.getId(), senderReceiverMap);
    }

    public List<SenderReceiverMap> getSenderReceiverList() {
        return new ArrayList<>(senderReceiverMapRecords.values());
    }

    public List<SenderReceiverMap> getExpense(String expenseId) {
        return new ArrayList<>((Collection) senderReceiverMapRecords.get(expenseId));
    }
}
