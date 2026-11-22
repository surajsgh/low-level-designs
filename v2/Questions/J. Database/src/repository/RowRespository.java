package repository;

import model.Row;

import java.util.*;

public class RowRespository {
    private Map<String, Row> rows = new HashMap<>();

    public void save(Row row) {
        this.rows.put(UUID.randomUUID().toString(), row);
    }

    public List<Row> getList() {
        return new ArrayList<>(rows.values());
    }
}
