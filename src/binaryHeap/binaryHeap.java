package binaryHeap;

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class binaryHeap {

	/** The number of children each node has **/
    private static final int d = 2;
    private int heapSize;
    private int[] heap;
    
    public binaryHeap(int capacity)
    {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
    
    //to check if the heap is empty
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }
 
    //to check if heap is full
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }
    
    //clear heap
    public void makeEmpty( )
    {
        heapSize = 0;
    }
    
    //Function to  get index parent of i
    private int parent(int i) 
    {
        return (i - 1)/d;
    }
    
    //to get index of kth child
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }
    
    //to insert elements
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }
    
    //find least element
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }
    
    //to delete min element
    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }
    
    //delete element at given index
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }
    
    //heapify up
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];    
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }
    
    //heapify down
    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }
    
    //to get smallest child
    private int minChild(int ind) 
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) 
        {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }
    
    //to print heap
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     
    
}
