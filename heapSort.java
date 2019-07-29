package main.java;

import java.util.Scanner;

public class heapSort {
	private static int[] heapsort(int array[],int i) {
		int temp;
		int len=array.length;
		if((len-1)>=2*i+1) {
			System.out.println("Comparing "+array[i]+" and "+array[2*i+1]);
			if(array[i]<array[2*i+1]) {
				temp=array[i];
				array[i]=array[2*i+1];
				array[2*i+1]=temp;
				//heapsort(array, 2*i+1);
				}	
			heapsort(array, 2*i+1);
			printArray(array);
		}
			
			
		if(len>2*i+1) {
			System.out.println("Comparing "+array[i]+" and "+array[2*i+1]);
			if(array[i]<array[2*i+1]) {
				temp=array[i];
				array[i]=array[2*i+1];
				array[2*i+1]=temp;
				//heapsort(array, 2*i+1);
				}
			heapsort(array, 2*i+1);
			printArray(array);
		}
		if((len-1)>=2*i+2) { 
			System.out.println("Comparing "+array[i]+" and "+array[2*i+2]);
			if(array[i]<array[2*i+2]) {
				temp=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=temp;
				//heapsort(array, 2*i+2);
				}
			heapsort(array, 2*i+2);
			printArray(array);
		}
			
			
		if(len>2*i+2) { 
			System.out.println("Comparing "+array[i]+" and "+array[2*i+2]);
			if(array[i]<array[2*i+2]) {
				temp=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=temp;
				//heapsort(array, 2*i+2);
				}
			heapsort(array, 2*i+2);
			printArray(array);
		}
			
			
		return array;
	}
	private static void printArray(int array[]) {
		int len=array.length;
		for(int i=0;i<len;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enyer size of array");
		int size=(int)sc.nextInt();
		int array[]=new int[size];
		for(int i=0;i<size;i++) {
			array[i]=(int)sc.nextInt();
		}
		System.out.print("Before sorting:");
		printArray(array);
		array=heapsort(array, 0);
		System.out.print("After sorting:");
		printArray(array);
	}
}
