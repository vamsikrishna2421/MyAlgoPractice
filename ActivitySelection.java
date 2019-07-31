package main.java;

public class ActivitySelection {
	
	public static void sort(int start[],int end[],int tasks[]) {
		for(int i=0;i<end.length;i++) {
			int small=i;
			for(int j=i+1;j<end.length;j++) {
				if(end[small]>end[j]) {
					small=j;
				}
			}
			int temp=end[i];
			end[i]=end[small];
			end[small]=temp;
			temp=start[i];
			start[i]=start[small];
			start[small]=temp;
			temp=tasks[i];
			tasks[i]=tasks[small];
			tasks[small]=temp;
		}
	}
	
	public static void selection(int start[],int end[],int tasks[]) {
		int endTimeofPrev=0;
		for(int i=0;i<end.length;i++) {
			if(start[i]>=endTimeofPrev) {
				System.out.println("Activity"+tasks[i]+" from "+start[i]+" to "+end[i]);
				endTimeofPrev=end[i];
			}
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
		int tasks[]= {1,2,3,4,5,6};
		int start[]= {0,3,1,5,5,8};
		int end[]= {6,4,2,9,7,9};
		sort(start,end,tasks);
		System.out.println("Start and end times are:");
		printArray(start);
		printArray(end);
		selection(start, end,tasks);
		
	}
}
