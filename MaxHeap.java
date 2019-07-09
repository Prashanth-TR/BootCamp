public class MaxHeap
{
    private int arr[];
    private int size;
    private int max;

    public MaxHeap(int max)
    {
        this.max = max;
        this.size = 0;
        this.arr = new int[max+1];
        this.arr[0] = -1;
    }
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        return false;
    }
    void swap(int A, int B)
    {
        int temp;
        temp = arr[A];
        arr[A] = arr[B];
        arr[B] = temp;
    }

    public void insert(int val)
    {
        arr[size++] = val;
        int current = size-1;
        while(arr[current]>arr[(current-1)/2])
        {
            swap(current, (current-1)/2);
            current = (current-1)/2;
        }
    }

    private void heapify(int pos)
    {
        if(pos>=(size/2)&&pos<=size)
            return;
        if(arr[pos]<arr[(pos*2)+1])
        {
            swap(pos, (pos*2)+1);
            heapify(pos);
        }
        if(arr[pos]<arr[(pos*2)+2])
        {
            swap(pos, (pos*2)+2);
            heapify(pos);
        }
    }

    public int getRoot()
    {
        return arr[0];
    }

    public int extractRoot()
    {
        int root = arr[0];
        arr[0] = arr[--size];
        heapify(0);
        return root;
    }

    public void printHeap()
    {
        while(!this.isEmpty())
        {
            System.out.println(this.extractRoot());
        }
    }

    public static void main(String args[])
    {
        MaxHeap heap = new MaxHeap(15);
        heap.insert(4);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(6);
        heap.insert(10);
        heap.insert(1);
        heap.printHeap();
    }
}