package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Huffman {
	public static class Node{
		char data;
		int freq;
		String codeString="";
		Node leftNode=null;
		Node rightNode=null;
		public Node(char d,int f,String c) {
			this.data=d;
			this.freq=f;
			this.codeString=c;
			this.leftNode=null;
			this.rightNode=null;
		}
	}
	int count=-1;
	public void combine(ArrayList<Node> Nodes) {
		int freq=0;
		count++;
		int temp=count;
		System.out.println("count is "+count);
		for(int i=1;i<Nodes.size();i++) {
			if(Nodes.get(temp).freq > Nodes.get(i).freq) {
				temp=i;
			}
		}
		Collections.swap(Nodes, count, temp);
//		Node temp1=Nodes.get(count);
//		Nodes.get(count)=Nodes.get(temp);
//		Nodes.get(temp)=temp1;
		freq=freq+Nodes.get(count).freq;
		count++;
		temp=count;
		System.out.println("count is "+count);
		for(int i=2;i<Nodes.size();i++) {
			if(Nodes.get(temp).freq>Nodes.get(i).freq) {
				temp=i;
			}
		}
		Collections.swap(Nodes, count, temp);
//		temp1=Nodes.get(count);
//		Nodes.get(count)=Nodes.get(temp);
//		Nodes.get(temp)=temp1;
		freq=freq+Nodes.get(count).freq;
		int length=Nodes.size();
		Nodes.add(new Node(' ',freq,""));
//		Nodes[length].freq=freq;
		Nodes.get(length).leftNode=Nodes.get(count-1);
		Nodes.get(length).rightNode=Nodes.get(count);
		if(((Nodes.size())-count-1)!=1) {
			combine(Nodes);
		}
	}
	
	public String childs(Node child) {
		if(child.leftNode==null && child.rightNode==null)
			return "";
		else {
			child.leftNode.codeString=childs(child.leftNode)+"0";
			System.out.println("codeString is "+child.leftNode.codeString);
			child.rightNode.codeString=childs(child.rightNode)+"1";
			System.out.println("codeString is "+child.rightNode.codeString);
		}
		return "";
	}
	
	public void printCodes(ArrayList<Node> Nodes,int length) {
		for(int i=0;i<length;i++) {
			System.out.println("Code for "+Nodes.get(i).data+" is "+Nodes.get(i).codeString);
		}
	}
	
	public Node[] create(int size) {
		Node Nodes[]=new Node[size];
		return Nodes;
	}
	
	public static void main(String args[]) {
		char[] c= {'a','b','c','d'};
		int[] freq= {3,9,5,1};
		Huffman hf=new Huffman();
		Node aNode=new Node('a',3,"");
		Node bNode=new Node('b',9,"");
		Node cNode=new Node('c',5,"");
		Node dNode=new Node('d',1,"");
		ArrayList<Node> Nodes = new ArrayList<Node>();
		Nodes.add(aNode);
		Nodes.add(bNode);
		Nodes.add(cNode);
		Nodes.add(dNode);
		//Node Nodes[]= {aNode,bNode,cNode,dNode};
//		Node xNode=new Node();
//		System.out.println("!   "+xNode.data+"!   ");
//		Node Nodes[] = new Node[c.length];
//		for(int i=0;i<c.length;i++) {
//			System.out.println("!   "+Nodes[i].data+"!   ");
//			Nodes[i].data=' ';
//			Nodes[i].freq=0;
//			Nodes[i].codeString="";
//     	}
//		Huffman hf=new Huffman();
//		Node Nodes[]=hf.create(c.length);
//		hf.printCodes(Nodes,c.length);
		for(int i=0;i<c.length;i++) {
			Nodes.get(i).data=c[i];
			Nodes.get(i).freq=freq[i];
		}
		hf.combine(Nodes);
		hf.childs(Nodes.get((Nodes.size())-1));
		hf.printCodes(Nodes,c.length);
	}
}
