package ada;

import java.util.Scanner;

public class FloydsEx {

	public static void main(String[] args) 
	{
		int n,i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		n=sc.nextInt();
		int cost[][] = new int [n+1][n+1];
		System.out.println("Enter the cost adjacency matrix (Enter 999 for infinity)");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
			{
				cost[i][j]=sc.nextInt();
			}

		floyds(cost,n);

		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print(cost[i][j]+"\t");
			}
			System.out.println();
		}

	}

	static int min(int a,int b)
	{
		return (a<b)?a:b;
	}

	static void floyds(int cost[][],int n)
	{
		int i,j,k;
		for(k=1;k<=n;k++)
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					cost[i][j]=min(cost[i][j],cost[i][k]+cost[k][j]);

	}
}
