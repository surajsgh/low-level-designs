import enums.Column;
import facade.DatabaseFacade;
import model.Row;
import repository.RowRespository;
import service.RowService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RowRespository rowRespository = new RowRespository();
        rowRespository.save(new Row("Suraj", 80, "CSE"));
        rowRespository.save(new Row("Mansi", 90, "CSE"));
        rowRespository.save(new Row("Dinesh", 70, "IT"));

        RowService rowService = new RowService(rowRespository);
        DatabaseFacade databaseFacade = new DatabaseFacade(rowService);

        List<Column> columns = new ArrayList<>();
        columns.add(Column.name);
        columns.add(Column.branch);

        System.out.println(databaseFacade.getRecords("", 0, "CSE"));
        rowService.print(databaseFacade.getRecordsUsingColumns(columns));

        System.out.println(databaseFacade.getCumulative(Column.name));
    }
}