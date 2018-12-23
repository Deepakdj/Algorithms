package ada;

import java.util.Scanner;

public class KruskalsEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int mincost=0,n,i,j,ne,a = 0,b = 0,min,u = 0,v = 0;			
		System.out.println("Enter the number of vertices\n");
		n=sc.nextInt();
		int cost[][]= new int [n+1][n+1];
		int parent[]=new int[n+1];
		System.out.println("Enter the cost matrix\n");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				cost[i][j]=sc.nextInt();
				if(cost[i][j]==0)
					cost[i][j]=999;
			}
		}
		ne=1;
		while(ne<n)
		{
			for(min=999,i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
					if(cost[i][j]<min)
					{
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
			}
			while(parent[u]!=0)
				u=parent[u];
			while(parent[v]!=0)
				v=parent[v];
			if(v!=u)
			{
				System.out.println((ne++)+"edge("+a+","+b+")="+min);
				mincost+=min;
				parent[v]=u;
			}
			cost[a][b]=cost[b][a]=999;
		}
		System.out.println("The minimum cost of spanning tree is "+mincost);
	}

}
