package service;

import enums.Column;
import model.DynamicEntity;
import model.Row;
import repository.RowRespository;

import java.util.ArrayList;
import java.util.List;

public class RowService {
    private RowRespository rowRespository;

    public RowService(RowRespository rowRespository) {
        this.rowRespository = rowRespository;
    }

    public List<Row> filterUsingColumns(String name, int marks, String branch) {
        List<Row> rows = this.rowRespository.getList();
        if (!name.isEmpty()) {
            rows = rows.stream().filter(row -> row.getName().equals(name)).toList();
        }
        if (marks!=0) {
            rows = rows.stream().filter(row -> row.getMarks()==marks).toList();
        }
        if (!branch.isEmpty()) {
            rows = rows.stream().filter(row -> row.getBranch().equals(branch)).toList();
        }
        return rows;
    }

    public List<DynamicEntity> getRowsUsingColumns(List<Column> columns) {
        List<DynamicEntity> dynamicEntities = new ArrayList<>();
        List<Row> rows = this.rowRespository.getList();
        for (Row row: rows) {
            DynamicEntity dynamicEntity = new DynamicEntity();
            for (Column column: columns) {
                if (column.equals(Column.name)) {
                    dynamicEntity.save("name", row.getName());
                }
                else if (column.equals(Column.marks)) {
                    dynamicEntity.save("marks", row.getMarks());
                }
                else {
                    dynamicEntity.save("branch", row.getBranch());
                }
            }
            dynamicEntities.add(dynamicEntity);
        }
        return dynamicEntities;
    }

    public int getCumulative(Column column) {
        int sum = 0;
        if (column!=Column.marks) {
            System.out.println("Invalid column provided");
            return sum;
        }
        List<DynamicEntity> dynamicEntities = getRowsUsingColumns(List.of(column));
        for (DynamicEntity dynamicEntity: dynamicEntities) {
            sum += (int) dynamicEntity.get("marks");
        }
        return sum;
    }

    public void print(List<DynamicEntity> dynamicEntities) {
        if (!dynamicEntities.isEmpty()) {
            for (DynamicEntity dynamicEntity: dynamicEntities) {
                Object name = dynamicEntity.get("name")==null ? "" : dynamicEntity.get("name");
                Object marks = dynamicEntity.get("marks")==null ? "" : dynamicEntity.get("marks");
                Object branch = dynamicEntity.get("branch")==null ? "" : dynamicEntity.get("branch");
                System.out.println(name + " " + marks + " " + branch);
            }
        }
    }
}
