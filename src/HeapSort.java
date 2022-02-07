
import java.util.*;
import java.lang.Math;

public class HeapSort {
    public static final int nMAX=5000000;
    public static final int m=13;

    static int n;
    public static SDATA a[];// =new SDATA[nMAX];

    public static  void main(String  argv[])
    {
        int i;
        int option;
        String s1,s2;
        if (argv.length>0)
        {
            s1=argv[0];
            n=Integer.parseInt(s1);
        }
//        else n=5500000;
        else n=500;
        if (argv.length>1)
        {
            s2=argv[1];
            option=Integer.parseInt(s2);
        }
        else option = 2;
        System.out.println("n="+n+", option (pattern type)="+option);
        a=new SDATA[n];
        System.out.println(" Array Length is "+a.length);

        switch (option)
        {
            case 1:{
                for (i=0;i<n;i++)
                {
                    a[i]=new SDATA(
                            (int)(Math.random() * nMAX*10),
                            (int)(Math.random() * nMAX*10)
                    );
                }
                break;
            }

            case 2:{
                for (i=0;i<n;i++)
                {
                    a[i]=new SDATA(i/m,((int)(Math.random() * nMAX*10))%m);
                }
                break;
            }

            case 3:
            {
                for (i=0;i<n;i++)
                {
                    a[i]=new SDATA(n+1-i,m+i);
                }
                break;
            }

            case 4:
            {
                for (i=n/2-1;i>=0;i--)
                {
                    //System.out.print("i="+i+"\n");
                    a[2*i]=new SDATA(2*i+2,m-1);
                    a[2*i+1]=new SDATA(2*i+1,m-1);
                }
                if ((n%2)!=0)
                {
                    a[n-1]=new SDATA(n+1,4);
                }
                break;
            }
            case 5:
            {
                for (i=n-1;i>=0;i--)
                {
                    if (i% (m/2) != 0 )
                    {
                        a[i]=new SDATA(i,m-5);
                    }
                    else
                    {
                        a[i]=new SDATA(m+(i+1)/m,m-5);
                    }
                }
                break;
            }
            case 6:{
                for (i=0;i<n;i+=2)
                {

                    if ((i% m)!=0)
                    {
                        a[i]=new SDATA(i,6);
                        if (i<n-1)
                            a[i+1]=new SDATA(i+1,6);
                    }
                    else
                    {
                        a[i]=new SDATA(i+1,6);
                        if (i<n-1)
                            a[i+1]=new SDATA(i,6);
                    }
                }
                break;
            }
            case 7:{
                for (i=0;i<n;i++)
                {
                    if ((i%2)!=0)
                    {
                        a[i]=new SDATA(i,7);
                    }
                    else
                    {
                        a[i]=new SDATA(n+3-i,7);
                    }
                }
                break;
            }
            default:
            {
                //System.out.println("Case 1");
                for (i=0;i<n;i++)
                {
                    a[i]=new SDATA(i+1,8);

                }
                break;
            }
        }

        for(i=0;i<n;i++)
            System.out.print("("+a[i].info +","+ a[i].infof +") ");
        System.out.println();
       try{
           long startTime = System.nanoTime();
           heapSort(a, n);
           long endTime = System.nanoTime();
           long tookTime = endTime - startTime;
           System.out.println(tookTime);
           System.out.println();
           System.out.print("Heap Sort");
           for(i=a.length-1; n>0 ;i--){
               System.out.print("("+a[i].info +","+ a[i].infof +") ");
           }
           System.out.println();
           System.out.println("the Algorithm took "+tookTime+" nanoseconds");

       }catch (ArrayIndexOutOfBoundsException exception){
           handleTheExceptionSomehow(exception);
       }
    }

    private static void handleTheExceptionSomehow(ArrayIndexOutOfBoundsException exception) {
    }

    public static void heapSort(SDATA[] A, int heap_size){
        int i;
        buildHeap(A, heap_size);
        for(i=heap_size-1; i>=1; i--){
            swap(A, 0, i);
            heap_size--;
            heapify(A, 0, heap_size);
        }
    }
    public static void heapify(SDATA[] A, int i, int heap_size){
        int smallest=0;
        int l,r;

        l = 2*i+1;
        r = 2*i+2;

        if((l <heap_size) && (A[l].info < A[i].info)){
            smallest = l;
        }
        else if((l < heap_size) && (A[l].info == A[i].info)){
            if (A[l].infof <= A[i].infof)
                smallest = l;
        }
        else{
            smallest = i;
        }

        if((r<heap_size) && (A[r].info < A[smallest].info)){
            smallest = r;
        }
        else if((r<heap_size) && (A[r].info == A[smallest].info)){
            if(A[r].infof <= A[smallest].infof){
                smallest = r;
            }
        }
        if(smallest != i){
            swap(A, i, smallest);
            heapify(A, smallest, heap_size);
        }
    }

    public static void buildHeap(SDATA[] A, int heap_size){
        int i;
        for( i=heap_size/2; i>=0; i--){
            heapify(A, i, heap_size);
        }
    }

    public static void swap(SDATA[] arr, int i, int j){
        SDATA temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
