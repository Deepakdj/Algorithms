package ada;

import java.util.Scanner;

public class SubsetEx {

	static int flag,count;
	static int x[],w[],d,n;

	public static void main(String[] args) {
		int r=0;
		flag=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of elements:");
		n=sc.nextInt();
		w = new int[n + 1];
		x = new int[n + 1];
		System.out.println("enter the elements into the set in increasing order:");
		for(int i=0;i<n;i++)
			w[i]=sc.nextInt();
		System.out.println("enter the value of sum:");
		d=sc.nextInt();
		for(int i=0;i<n;i++)
			x[i]=0;
		for(int i=0;i<n;i++)
			r+=w[i];
		if(r<d)
		{
			System.out.println("no subset is possible\n");
			flag=1;
		}
		else
			sum(0,0,r);
		if(flag==0)
		{
			System.out.println("no more subset is possible\n");
		}

	}

	static void sum(int s,int k,int r)
	{
		x[k]=1;
		if(s+w[k]==d)
		{
			System.out.println("\nsubset :"+(++count));
			flag=1;
			for(int i=0;i<=k;i++)
				if(x[i]==1)
					System.out.print(w[i]+" ");
		}
		else if(s+w[k]+w[k+1]<=d)
			sum(s+w[k],k+1,r-w[k]);
		if((s+r-w[k])>=d && (s+w[k+1]<=d))
		{
			x[k]=0;
			sum(s,k+1,r-w[k]);
		}
	}

}
