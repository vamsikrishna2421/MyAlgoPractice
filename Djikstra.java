package main.java;

public class Djikstra {
	
	
	public int[] minimum_tree(int graph[][],int V) {
		int dist[]=new int[V];
		boolean sptSet[]=new boolean[V];
		for(int i=0;i<V;i++) {
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		print(dist);
		dist[0]=0;
		for(int i=0;i<V-1;i++) {
			int u=min_dist_index(dist, sptSet);
			sptSet[u]=true;
			for(int v=0;v<V;v++) {
				if(sptSet[v]!=true && graph[u][v]!=0 && graph[u][v]+dist[u]<dist[v]) {
					dist[v]=dist[u]+graph[u][v];
				}
			}
			print(dist);
			
		}
		return dist;
	}
	
	public int min_dist_index(int dist[],boolean sptSet[]) {
		int min=Integer.MAX_VALUE;
		int min_index=-1;
		for(int i=0;i<dist.length;i++) {
			if(dist[i]<min && sptSet[i]==false) {
				min=dist[i];
				min_index=i;
			}
		}
		return min_index;
	}
	
	public void print(int dist[]) {
		System.out.println("Distances from source vertex:");
		System.out.println("vertex \t distance");
		for (int i = 0; i < dist.length; i++) {
			System.out.println(i+"    \t      "+dist[i]);
		}
	}
	
	public static void main(String []args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                {0, 0, 2, 0, 0, 0, 6, 7, 0} 
               };
        int V=9;
        Djikstra d=new Djikstra();
		int dist[]=d.minimum_tree(graph,V);
		d.print(dist);
	}
}
