public class Record {
    private String type;
    private int five;
    private int seven;
    private int nine;
    private int eleven;
    private int twelve;
    private int fourteen;
    private int seventeen;
    private int nineteen;
    private int size;
    private boolean highlight;

    public Record(String type, int five, int seven, int nine, int eleven, int twelve, int fourteen, int seventeen, int nineteen){
        this.type = type;
        this.five = five;
        this.seven = seven;
        this.nine = nine;
        this.eleven = eleven;
        this.twelve = twelve;
        this.fourteen = fourteen;
        this.seventeen = seventeen;
        this.nineteen = nineteen;
        highlight = false;
    }

    public String getType(){
        return type;
    }

    public int getFive(){
        return five;
    }

    public int getSeven(){
        return seven;
    }

    public int getNine(){
        return nine;
    }

    public int getEleven(){
        return eleven;
    }

    public int getTwelve(){
        return twelve;
    }

    public int getFourteen(){
        return fourteen;
    }

    public int getSeventeen(){
        return seventeen;
    }

    public int getNineteen(){
        return nineteen;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int year, Record record){
        if(year == 2005){
            size = record.getFive() / 90;
        } else if(year == 2007){
            size = record.getSeven() / 90;
        } else if(year == 2009){
            size = record.getNine() / 90;
        } else if (year == 2011){
            size = record.getEleven() / 90;
        } else if(year == 2012){
            size = record.getTwelve() / 90;
        } else if (year == 2014){
            size = record.getFourteen() / 90;
        } else if(year == 2017){
            size = record.getSeventeen() / 90;
        } else if(year == 2019){
            size = record.getNineteen() / 90;
        }
    }

    public boolean getHighlight(){
        return highlight;
    }

    public void setHighlight(boolean highlight){
        this.highlight = highlight;
    }



}