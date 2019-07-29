package main.java;

public class QuickSort {
	private int partition(int array[],int low , int high) {
		int pivot=array[high];
		int i=(low-1);
		for (int j = low; j < high; j++) {
			if(array[j]<=pivot) {
				i++;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		
		int temp=array[i+1];
		array[i+1]=array[high];
		array[high]=temp;
		return i+1;
	}
	
	private  void sort(int array[],int low,int high) {
		if(low<=high) {
			int pi=partition(array,low,high);
			printArray(array);
			sort(array, low, pi-1);
			sort(array, pi+1, high);
		}
	}
	
	private static void printArray(int array[]) {
		int len=array.length;
		for(int i=0;i<len;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		int array[]= {10,80,30,90,40,50,70};
		System.out.print("Before sort:");
		printArray(array);
		QuickSort ob=new QuickSort();
		ob.sort(array,0,array.length-1);
		System.out.print("After sort:");
		printArray(array);
	}
}
