package facade;

import enums.Column;
import model.DynamicEntity;
import model.Row;
import service.RowService;

import java.util.List;

public class DatabaseFacade {
    private RowService rowService;

    public DatabaseFacade(RowService rowService) {
        this.rowService = rowService;
    }

    public List<Row> getRecords(String name, int marks, String branch) {
        return this.rowService.filterUsingColumns(name, marks, branch);
    }

    public List<DynamicEntity> getRecordsUsingColumns(List<Column> columns) {
        return this.rowService.getRowsUsingColumns(columns);
    }

    public int getCumulative(Column column) {
        return this.rowService.getCumulative(column);
    }
}
