package heap;

public class MaxPQ {
    // we start in the index 1
    Integer[] heap;
    int n;

    public MaxPQ(int capacity){
        heap = new Integer[capacity + 1]; // comecamos do 1
    }

    public boolean isEmpty(){
        return n ==0;
    }

    public int size(){
        return n;
    }



}
