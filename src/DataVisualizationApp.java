import processing.core.PApplet;

public class DataVisualizationApp extends PApplet {
    private static DataVisualizationApp app;
    private Dataset dataset;
    private int foundAt;

    public static void main(String[] args){
        app = new DataVisualizationApp();
        app.runSketch();
    }

    public DataVisualizationApp(){
        foundAt = -1;
    }

    public void settings(){
        size(1000, 1000);
    }

    public void setup(){
        dataset = new Dataset();
        fill(0);
    }

    public void draw(){
        background(255);
        displayRecords();
    }

    public void keyPressed(){
        if (key == 'e'){
            foundAt = dataset.find("potato");
        } else if (key == 'o'){
            dataset.sort();
        }
    }

    public static DataVisualizationApp getApp(){
        return app;
    }

    private void displayRecords(){
        Record[] records = dataset.getRecords();
        text("PRODUCE TYPE", 100, 25);
        text("2005", 300, 25);
        text("2007", 375, 25);
        text("2009", 450, 25);
        text("2011", 525, 25);
        text("2012", 600, 25);
        text("2014", 675, 25);
        text("2017", 750, 25);
        text("2019", 825, 25);

        //records.sort();

        int y = 75;
        for (int i = 0; i < records.length; i++){
            Record record = records[i];

            if (foundAt == i){
                fill(255, 0, 0);
            }
            text(record.getType(), 100, y);

            fill(0);
            text(record.getFive(), 300, y);
            text(record.getSeven(), 375, y);
            text(record.getNine(), 450, y);
            text(record.getEleven(), 525, y);
            text(record.getTwelve(), 600, y);
            text(record.getFourteen(), 675, y);
            text(record.getSeventeen(), 750, y);
            text(record.getNineteen(), 825, y);
            y += 50;
        }
    }
}
