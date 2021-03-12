class MovingAverage {
    private int count;
    private int size;
    private int[] arr;
    private int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.count = 0;
        this.size = size;
        this.arr = new int[size];
    }
    
    public double next(int val) {
        int tmp = arr[count%size];
        this.arr[count%size] = val;
        count++;
        if(count>size){
            sum =sum + val - tmp;
            return (double)sum/size;
        }
        sum = sum +val;
        return (double)sum/count;
    }
}
