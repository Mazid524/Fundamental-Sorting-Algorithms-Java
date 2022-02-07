
import java.util.*;
import java.lang.Math;

public class QuickSort {
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
        else n = 13000;
        if (argv.length>1)
        {
            s2=argv[1];
            option=Integer.parseInt(s2);
        }
        else option = 8;
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
        long startTime = System.nanoTime();
        System.out.println("Time Start "+  startTime);
        quickSort(a, 0, n-1);
        System.out.println();
        System.out.print("Quick Sorted: ");
        for(i=0; i<n; i++){
            System.out.print("("+a[i].info +","+ a[i].infof +") ");
        }
        System.out.println();
        long endTime = System.nanoTime();
        System.out.println("Time Ends at "+ endTime );
        long tookTime = endTime - startTime;
        System.out.println("The algorithm took "+tookTime+" nano seconds");
    }

    static void quickSort(SDATA[] arr, int first, int last)
    {
        if (first < last)
        {
            int pi = partition(arr, first, last);
            quickSort(arr, first, pi - 1);
            quickSort(arr, pi + 1, last);
        }
    }

    static int partition(SDATA[] arr, int low, int high)
    {

        // pivot
        SDATA pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].info < pivot.info)
            {
                i++;
                swap(arr, i, j);
            }
            else if(arr[j].info == pivot.info){
                if(arr[j].infof <= pivot.infof){
                    i++;
                    swap(arr, i,j);
                }
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void swap(SDATA[] arr, int i, int j)
    {
        SDATA temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
