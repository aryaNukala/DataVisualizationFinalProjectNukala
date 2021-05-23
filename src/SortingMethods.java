public class SortingMethods {

    public SortingMethods() {
    }

    public static void sort(Record[] records){
        //SortingMethods.selectionSort(records);
        SortingMethods.insertionSort(records);
        //SortingMethods.mergeSort(records);
    }

    private static void selectionSort(Record[] records) {
        for(int i = 0; i < records.length; i++){
            for(int j = 0; j < records.length; j++){
                if(records[i].getType().compareTo(records[j].getType()) < records[j].getType().compareTo(records[i].getType())){
                    Record record = records[i];
                    records[i] = records[j];
                    records[j] = record;
                }
            }
        }
    }

    private static void insertionSort(Record[] records) {
        int n = records.length;
        for (int j = 1; j < n; j++) {
            Record key = records[j];
            int i = j - 1;
            while ( (i > -1) && (records[i].getType().compareToIgnoreCase(key.getType()) > key.getType().compareToIgnoreCase(records[i].getType()))) {
                 records[i + 1] = records[i];
                i--;
            }
            records[i + 1] = key;
        }
    }

    private static void mergeSort(Record[] records) {
        if(records == null){
            return;
        }
        if(records.length > 1){
            int middle = records.length / 2;

            Record[] left = new Record[middle];
            for(int i = 0; i < middle; i++){
                left[i] = records[i];
            }

            Record[] right = new Record[records.length - middle];
            for(int i = middle; i < records.length; i++){
                right[i - middle] = records[i];
            }

            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            while(i < left.length && j < right.length){
                if(left[i].getType().compareTo(right[j].getType()) < right[j].getType().compareTo(left[i].getType())) {
                    records[k] = left[i];
                    i++;
                }
                else {
                    records[k] = right[j];
                    j++;
                }
                k++;
            }

            // remaining elements
            while(i < left.length) {
                records[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length) {
                records[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
