import processing.data.Table;
import processing.data.TableRow;

public class Dataset implements Searchable, Sortable {
    private final Record[] records;

    public Dataset() {
        DataVisualizationApp app = DataVisualizationApp.getApp();
        Table table = app.loadTable("data/tabularData.csv", "header");
        records = new Record[table.getRowCount()];
        for (int i = 0; i < records.length; i++) {
            TableRow row = table.getRow(i);
            String type = row.getString("Produce Type");
            int five = row.getInt("2005");
            int seven = row.getInt("2007");
            int nine = row.getInt("2009");
            int eleven = row.getInt("2011");
            int twelve = row.getInt("2012");
            int fourteen = row.getInt("2014");
            int seventeen = row.getInt("2017");
            int nineteen = row.getInt("2019");
            records[i] = new Record(type, five, seven, nine, eleven, twelve, fourteen, seventeen, nineteen);
        }
    }

    public Record[] getRecords() {
        return records;
    }

    @Override
    public void sort() {
        SortingMethods.sort(records);
    }

    @Override
    public int find(String country) {
        return SearchingMethods.search(records, country);
    }
}
