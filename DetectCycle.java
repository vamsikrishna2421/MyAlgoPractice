package main.java;

public class DetectCycle {
	int E;
	int V;
	Edge edge[];
	class Edge{
		int src,dst;
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
	
	public void detectCycle(DetectCycle graph) {
		int Parent[]= new int[graph.V];
		
		for(int i=0;i<graph.V;i++) {
			Parent[i]=-1;
		}
		
		for (int i = 0; i < graph.E; i++) {
			int x=graph.find(Parent,graph.edge[i].src);
			int y=graph.find(Parent,graph.edge[i].dst);
			if(x==y) {
				System.out.println("Graph has cycle");
				return;
			}
			Parent[graph.find(Parent, x)]=graph.find(Parent, y);
		}
		System.out.println("Graph is non-cyclic");
	}
	
	public static void main(String [] args) {
		DetectCycle graph=new DetectCycle();
		graph.graph(3,3);
		
		graph.edge[0].src=0;
		graph.edge[0].dst=1;
		graph.edge[1].src=1;
		graph.edge[1].dst=2;
		graph.edge[2].src=2;
		graph.edge[2].dst=0;
		
		graph.detectCycle(graph);
	}
}
