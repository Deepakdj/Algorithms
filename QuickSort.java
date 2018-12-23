package ada;
import java.util.*;
import java.io.*;
public class QuickSort {

	public static void main(String a[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of elements to sort: ( >5000):");
		int n;
		n =  scanner.nextInt();
		int [] inputArr = new int [n+1];
		inputArr[n]=999999;
		PrintWriter out = new PrintWriter(new File("RandomNos.txt"));
		Random rand = new Random();
		for( int i=0; i<n ; i++)
		{
			inputArr[i]=rand.nextInt(n);
			out.print(inputArr[i]);
			out.print(" ");
		}
		out.close();
		long startTime = System.nanoTime();
		quicksort(inputArr, 0, n-1);
		long estimatedTime = System.nanoTime() - startTime;
		PrintWriter outA = new PrintWriter(new File("SortedNos.txt"));
		
		for( int i=0; i<n ; i++)
		{
			outA.print(inputArr[i]);
			outA.print(" ");
		}
		outA.close();

		System.out.println("The time for sorting is " + (estimatedTime/1000000000.0)+ " secs");
	}


	static void quicksort(int a[],int l,int r)
	{
		int s;
		if(l<r)
		{
			s=partition(a,l,r);
			quicksort(a,l,s-1);
			quicksort(a,s+1,r);
		}
	}

	static int partition(int a[],int l,int r)
	{
		int i,j;
		int p;
		p=a[l];
		i=l;
		j=r+1;
		do
		{
			do{	i++;  }while(a[i]<p);				
			do{	j--;  }while(a[j]>p);
			swap(a,i,j);
		}while(i<j);		
		swap(a,i,j);
		swap(a,l,j);
		return j;
	}

	static void swap(int a[],int i,int j)
	{
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
