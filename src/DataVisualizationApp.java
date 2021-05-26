import processing.core.PApplet;

public class DataVisualizationApp extends PApplet {
    private static DataVisualizationApp app;
    private Dataset dataset;
    private int foundAt;
    private int year;
    private Record[] records;

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
        records = dataset.getRecords();
        background(0);
        fill(0);
        year = 2005;
    }

    public void draw(){
        background(255);
        displayRecords();
    }

    public void mouseClicked(){
        super.mouseClicked();
        if((mouseX > 600 && mouseX < 640) && (mouseY > 40 && mouseY < 70)){
            handleYear(false);
        } if((mouseX > 650 && mouseY < 690) && (mouseY > 40 && mouseY < 70)){
            handleYear(true);
        } if(mouseX > 25 && mouseX < 100){
            if (mouseY > 725 && mouseY < 735) {
                foundAt = dataset.find("apple");
            } if (mouseY > 740 && mouseY < 750){
                foundAt = dataset.find("avocado");
            } if(mouseY > 755 && mouseY < 765){
                foundAt = dataset.find("kiwi");
            } if(mouseY > 770 && mouseY < 780){
                foundAt = dataset.find("olive");
            } if(mouseY > 785 && mouseY < 795){
                foundAt = dataset.find("onion");
            } if(mouseY > 800 && mouseY < 810){
                foundAt = dataset.find("potato");
            } if(mouseY > 815 && mouseY < 825){
                foundAt = dataset.find("squash");
            } if(mouseY > 830 && mouseY < 840){
                foundAt = dataset.find("wine grape");
            }
            if(foundAt != -1) {
                records[foundAt].setHighlight(!records[foundAt].getHighlight());
            }
        }
    }

    public void handleYear(boolean up){
        if(up == true) {
            if (year == 2005) {
                year = 2007;
            } else if (year == 2007) {
                year = 2009;
            } else if (year == 2009) {
                year = 2011;
            } else if (year == 2011){
                year = 2012;
            } else if (year == 2012){
                year = 2014;
            } else if (year == 2014){
                year = 2017;
            } else if (year == 2017){
                year = 2019;
            } else {
                year = 2005;
            }
        } else {
            if (year == 2005) {
                year = 2019;
            } else if (year == 2007) {
                year = 2005;
            } else if (year == 2009) {
                year = 2007;
            } else if (year == 2011){
                year = 2009;
            } else if (year == 2012){
                year = 2011;
            } else if (year == 2014){
                year = 2012;
            } else if (year == 2017){
                year = 2014;
            } else {
                year = 2017;
            }
        }
    }

    public static DataVisualizationApp getApp(){
        return app;
    }

    private void displayRecords(){
        dataset.sort();

        textAlign(CENTER, CENTER);
        strokeWeight(2);
        fill(0);

        textSize(40);
        text(year, 500, 50);

        textSize(15);
        textAlign(LEFT, LEFT);
        text("key", 50, 700);

        fill(210);
        rect(600, 40, 40, 30);
        rect(650, 40, 40, 30);
        textAlign(CENTER,CENTER);
        fill(0);
        text("<", 620, 53);
        text(">", 670, 53);

        textSize(15);
        textAlign(LEFT, LEFT);
        text("key", 50, 700);

        for(int i = 0; i < records.length; i++){
            int x;
            int y;
            String type = records[i].getType();
            records[i].setSize(year, records[i]);

            textSize(10);
            textAlign(LEFT, LEFT);

            if(type.equals("Avocado")){
                fill(156, 175, 136);
                x = 150; y = 200;
                text("Avocado", 50, (734 + 15 * i));
            } else if (type.equals("Kiwi")){
                fill(193, 204, 137);
                x = 150; y = 550;
                text("Kiwi", 50, (734 + 15 * i));
            } else if(type.equals("Potato")){
                fill(191, 160, 143);
                x = 500; y = 200;
                text("Potato", 50, (734 + 15 * i));
            } else if(type.equals("Onion")){
                fill(217, 168, 143);
                x = 850; y = 550;
                text("Onion", 50, (734 + 15 * i));
            } else if(type.equals("Squash")){
                fill(202, 143, 66);
                x = 300; y = 350;
                text("Squash", 50, (734 + 15 * i));
            } else if(type.equals("Olive")){
                fill(117, 158, 139);
                x = 625; y = 350;
                text("Olive", 50, (734 + 15 * i));
            } else if(type.equals("Wine Grape")){
                fill(176, 102, 96);
                x = 500; y = 625;
                text("Wine Grapes", 50, (734 + 15 * i));
            } else {
                fill(216, 118, 90);
                x = 850; y = 250;
                text("Apple", 50, (734 + 15 * i));
            }

            if(records[i].getHighlight() == true){
                stroke(255, 255, 0);
                strokeWeight(15);
            }
            ellipse(x, y, records[i].getSize(), records[i].getSize());
            stroke(0);
            strokeWeight(2);
            rect(25, (725 + 15 * i), 10, 10);
            stroke(0);
            strokeWeight(2);
        }

        int y = 75;
        for (int i = 0; i < records.length; i++){
            Record record = records[i];

            if (foundAt == i){
                fill(255, 0, 0);
            }
        }
    }
}
