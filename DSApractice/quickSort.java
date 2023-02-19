public class quickSort {
    static void quickS(int arr[], int l, int h){
        // base case

        if(l>=h) return;

        // partition
        int ind = partition(arr, l, h);

        // Quick Sort recursion
        quickS(arr, l, ind-1);
        quickS(arr, ind+1, h);
    }


    static int partition(int arr[], int l, int h){
        int pivot = arr[l];
        int cnt =0;
        for(int i = l+1; i<=h; i++){
            if(arr[i] <= pivot){
                cnt++;
            }
        }

        int pivotInd = l+cnt;

        int temp = arr[pivotInd];
        arr[pivotInd] = arr[l];
        arr[l] = temp;


        int i=l, j =h;


        while(i<pivotInd && j > pivotInd){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }

            if(i < pivotInd && j > pivotInd){
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;

                i++; j--;
            }
        }
        return pivotInd;
    }


    public static void main(String[] args) {
        int arr[] = {3,5,1,8,2,4};
        int l =0;
        int h = arr.length-1;

        quickS(arr, l, h);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }        
    }   
}
