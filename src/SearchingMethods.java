public class SearchingMethods {

    public SearchingMethods(){
    }

    public static int search(Record[] records, String type){
        //return SearchingMethods.linearSearch(records, type);
        return SearchingMethods.binarySearch(records, type);
    }

    private static int linearSearch(Record[] records, String type){
        int index = -1;
        for(int i = 0; i < records.length; i++){
            if(records[i].getType().compareToIgnoreCase(type) == 0){
                index = i;
            }
        }
        return index;
    }

    private static int binarySearch(Record[] records, String type) {
        //selection sort in case user has not already been sorted
        for(int i = 0; i < records.length; i++){
            for(int j = 0; j < records.length; j++){
                if(records[i].getType().compareTo(records[j].getType()) < records[j].getType().compareTo(records[i].getType())){
                    Record record = records[i];
                    records[i] = records[j];
                    records[j] = record;
                }
            }
        }

        //binary search
        int low = 0;
        int high = records.length - 1;
        int middle;

        while (low <= high) {
            middle = (high + low) / 2;

            if (records[middle].getType().compareToIgnoreCase(type) < 0) {
                low = middle + 1;
            } else if (records[middle].getType().compareToIgnoreCase(type) > 0) {
                high = middle - 1;
            } else if (records[middle].getType().compareToIgnoreCase(type) == 0){
                return middle;
            }
        }
        return -1;
    }
}
