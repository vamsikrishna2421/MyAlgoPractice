package main.java;

public class Kruskals {
	int E;
	int V;
	Edge edge[];
	class Edge{
		int src,dst,weight;
	}
	public void graph(int v,int e) {
		V=v;
		E=e;
		edge=new Edge[E];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	
	public int find(int Parent[],int i) {
		if(Parent[i]==-1)
			return i;
		return find(Parent, Parent[i]);
	}
	
	public boolean detectCycle(Kruskals graph,int totalNodes) {
		int Parent[]= new int[totalNodes];
		System.out.println("No. of vertices is "+graph.V);
		for(int i=0;i<totalNodes;i++) {
			Parent[i]=-1;
		}
		
		for (int i = 0; i < graph.E; i++) {
			int x=graph.find(Parent,graph.edge[i].src);
			int y=graph.find(Parent,graph.edge[i].dst);
			if(x==y) {
				System.out.println("Graph has cycle");
				return true;
			}
			Parent[graph.find(Parent, x)]=graph.find(Parent, y);
		}
		System.out.println("Graph is non-cyclic");
		return false;
	}
	
	public void sort(Edge edge[]) {
		for(int i=0;i<edge.length;i++) {
			int small=i;
			for(int j=i+1;j<edge.length;j++) {
				if(edge[small].weight>edge[j].weight) {
					small=j;
				}
			}
			int temp=edge[i].src;
			edge[i].src=edge[small].src;
			edge[small].src=temp;
			temp=edge[i].dst;
			edge[i].dst=edge[small].dst;
			edge[small].dst=temp;
			temp=edge[i].weight;
			edge[i].weight=edge[small].weight;
			edge[small].weight=temp;
		}
	}
	
	public static void printGraph(Edge edge[]) {
		for (int i = 0; i < edge.length; i++) {
			System.out.println("From "+edge[i].src+" to "+edge[i].dst+" with weight  "+edge[i].weight);
		}
	}
	
	public static void main(String args[]) {
		Kruskals graph=new Kruskals();
		graph.graph(3,3);
		int totalNodes=3;
		graph.edge[0].src=0;
		graph.edge[0].dst=1;
		graph.edge[0].weight=3;
		graph.edge[1].src=1;
		graph.edge[1].dst=2;
		graph.edge[1].weight=1;
		graph.edge[2].src=2;
		graph.edge[2].dst=0;
		graph.edge[2].weight=2;
		
		graph.sort(graph.edge);
		printGraph(graph.edge);
		
//		int Parent[]= new int[graph.V];
//		System.out.println("No. of vertices is "+graph.V);
//		for(int i=0;i<graph.V;i++) {
//			Parent[i]=-1;
//		}
		
		Kruskals newgraph=new Kruskals();
		newgraph.graph(3, 2);
		
		int j=0;
		for(int i=0;i<graph.V-1;i++) {
			Kruskals temp=new Kruskals();
			temp.graph(j+2, j+1);
			for(int x=0;x<j;x++)
				temp.edge[x]=newgraph.edge[x];
			
			temp.edge[j]=graph.edge[i];
			System.out.println("Value of i is "+i);
			printGraph(temp.edge);
			if(temp.detectCycle(temp,totalNodes)==false) {
				newgraph.edge[i]=temp.edge[i];
				j++;
			}
		}
		printGraph(newgraph.edge);
	}
}
