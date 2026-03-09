class missing_num {
    int missingNum(int arr[]) {
        int n = arr.length + 1;  
        
        int totalSum = n * (n + 1) / 2;
        
        int arrSum = 0;
        for(int i = 0; i < arr.length; i++){
            arrSum += arr[i];
        }
        
        return totalSum - arrSum;
    }
}