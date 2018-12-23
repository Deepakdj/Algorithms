package ada;


import java.util.Scanner;

public class TspEx {
	static int cost[][];
	public static void main(String[] args) {

		int n,i,j,mincost;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of cities:");
		n=sc.nextInt();
		cost=new int[n+1][n+1];
		int path[]= new int[n+1];
		System.out.println("Enter the cost matrix and enter 999 for no connection:\n");
		for (i=1; i<=n; i++) 
			for (j=1; j<=n; j++) 
				cost[i][j]=sc.nextInt();

		for (i=1; i<=n; i++) 
			path[i] = i; 

		System.out.println("TSP using dynamic programming");
		mincost = tsp(path,1,n);  
		System.out.print("TSP tour is:");  
		for (i=1; i<=n; i++) 
			System.out.print(path[i]+"-->"); 
		System.out.print("1"); 
		System.out.println("TSP tour cost="+mincost); 
	}



	static int tsp(int path[], int start,int n)
	{
		int i, j, k,mincost,ccost;
		int mintour[]=new int[n+1];
		int temp[]=new int[n+1];
		if (start == n - 1)
			return cost[path[n-1]][path[n]] + cost[path[n]][1];
		mincost = 999;
		for (i = start+1; i<=n; i++)
		{ 
			for (j=1; j<=n; j++)
				temp[j] = path[j];
			temp[start+1] = path[i];
			temp[i] = path[start+1];
			if (cost[path[start]][path[i]] +(ccost = tsp(temp, start+1,n)) < mincost)
			{
				mincost = cost[path[start]][path[i]] + ccost;
				for (k=1; k<=n; k++)
					mintour[k] = temp[k];
			}
		}
		for (i=1; i<=n; i++)
			path[i] = mintour[i];
		return mincost;
	}

}
