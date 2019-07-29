package main.java;

public class SinglyLinkedList {
	//private ListNode head;
	
	public void display(ListNode head) {
		if (head==null) {
			System.out.println("list is empty");
			return;
		}
		ListNode currentNode=head;
		while (currentNode!=null) {
			System.out.print(currentNode.data+"-->");
			currentNode=currentNode.next;
		}
		System.out.println(currentNode);
	}
	
	public int length(ListNode head) {
		if (head==null) {
			return 0;
		}
		ListNode currentNode=head;
		int count = 0;
		while (currentNode!=null) {
			count++;
			currentNode=currentNode.next;
		}
		return count;
	}
	
	public ListNode addNode(ListNode head,int data) {
		ListNode newNode=new ListNode(data);
		if (head==null) {
			return newNode;
		}
		ListNode currentNode =head;
		while(currentNode.next!=null) {
			currentNode=currentNode.next;
		}
		currentNode.next=newNode;
		return head;
	}
	
	public ListNode addNodeAtBeg(ListNode head,int data) {
		ListNode newNode=new ListNode(data);
		if (head==null) {
			return newNode;
		}
		newNode.next=head;
		return newNode;
	}
	
	public ListNode addNodeAtPos(ListNode head,int data,int position) {
		int length=length(head);
		ListNode newNode=new ListNode(data);
		if(position==0) {
			head=addNodeAtBeg(head, data);
			return head;
		}
		if (length<position) {
			System.out.println("Length of list is lesser than requested position.");
			//addNode(head, data);  //if needed to add at end
			return head;
		}
		ListNode currentNode=head;
		int pos=position;
		int currentpos=0;
		while (currentpos<pos-1) {
			currentNode=currentNode.next;
			currentpos++;
		}
		ListNode nextNode=currentNode.next;
		currentNode.next=newNode;
		newNode.next=nextNode;
		return head;
	}
	
	public ListNode popNode(ListNode head) {
		ListNode currentNode=head;
		ListNode prevNode=null;
		if(head==null) {
			System.out.println("Head is empty");
			//System.out.println((Integer)null);
			return head;
		}
		else if(head.next==null) {
//			ListNode lastNode=head;
			head=null;
			return head;
		}
		while (currentNode.next!=null) {
			prevNode=currentNode;
			currentNode=currentNode.next;
		}
		prevNode.next=null;
		return head;
	}
	
	public ListNode deleteFirstNode(ListNode head) {
		if(head==null) {
			System.out.println("list is empty");
			return head;
		}
		head=head.next;
		return head;
	}
	
	public ListNode deleteNodeAtPos(ListNode head,int position) {
		int length=length(head);
		if(position==0) {
			head=deleteFirstNode(head);
			return head;
		}
		if(length-1<position) {
			System.out.println("list is shorted than given position");
			return head;
		}
		int pos=position;
		int count=0;
		ListNode currentNode=head;
		while(count<pos-1) {
			currentNode=currentNode.next;
			count++;
		}
		currentNode.next=currentNode.next.next;
		return head;
	}
	
	public ListNode reverseList(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode current=head;
		ListNode prev=null;
		ListNode next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}
	
	public int getPosition(ListNode head,int data) {
		int count=0;
		ListNode currentNode=head;
		while(currentNode.next!=null) {
			if (currentNode.data==data) {
				return count+1;
			}
			currentNode=currentNode.next;
			count++;
		}
		return -1;
	}
	
	public ListNode getMiddleNode(ListNode head) {
		int length=length(head);
		int position;
		ListNode currentNode=head;
		if(length%2==0) {
			position=(length/2)-1;
		}
		else {
			position=(length-1)/2;
		}
		int count=0;
		while(count<position) {
			currentNode=currentNode.next;
			count++;
		}
		return currentNode;
	}
	
	public ListNode getMiddleNode2(ListNode head) {
		ListNode currentNode1=head;
		ListNode currentNode2=head;
		ListNode prevTonode1=null;
		while(currentNode2!=null && currentNode2.next!=null) {
			currentNode2=currentNode2.next.next;
			prevTonode1=currentNode1;
			currentNode1=currentNode1.next;
		}
		return prevTonode1;
	}
	
	public ListNode nthnodefromend(ListNode head,int n) {
		int length=length(head);
		if(n>length) {
			System.out.println("List is shorter");
			return null;
		}
		ListNode mainptr=head;
		ListNode refptr=head;
		int count=0;
		while(count<n-1) {
			refptr=refptr.next;
			count++;
		}
		while(refptr.next!=null) {
			refptr=refptr.next;
			mainptr=mainptr.next;
		}
		return mainptr;
	}
	
	public ListNode removedup(ListNode head) {
		ListNode currentNode=head;
		
		while(currentNode!=null && currentNode.next!=null) {
			if(currentNode.data==currentNode.next.data) {
				currentNode.next=currentNode.next.next;
			}
			else {
				currentNode=currentNode.next;
			}
		}
		return head;
	}
	
	public ListNode removenodewithvalue(ListNode head,int key) {
		if(head.data==key) {
			head=head.next;
			return head;
		}
		ListNode currentNode=head;
		ListNode prevtocurrent=null;
		while(currentNode!=null && currentNode.data!=key) {
			prevtocurrent=currentNode;
			currentNode=currentNode.next;
		}
		if(currentNode!=null)
			prevtocurrent.next=currentNode.next;
		return head;
	}
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		ListNode head = null;
//		ListNode head =new ListNode(10);
//		ListNode second =new ListNode(8);
//		ListNode third =new ListNode(1);
//		ListNode fourth =new ListNode(11);
//		head.next=second;
//		second.next=third;
//		third.next=fourth;
		//System.out.println(head.next.next.data);
		
		//print the list
//		ListNode currentNode=head;
//		while (currentNode!=null) {
//			System.out.println(currentNode.data);
//			currentNode=currentNode.next;
//  	}
		SinglyLinkedList list=new SinglyLinkedList();
		
		//adding nodes
		head=list.addNode(head,1);
		head=list.addNode(head,3);
		head=list.addNode(head,5);
		head=list.addNode(head,7);
		head=list.addNode(head,9);
		head=list.addNode(head,11);
		//testing addNodeAtBeg(),addNodeAtPos()
		//head=list.addNodeAtBeg(head, 0);
		//head=list.addNode(head,13);
		//head=list.addNodeAtPos(head, 11, 6);
		//head=list.addNodeAtPos(head, 15, 8);
		//head=list.addNodeAtPos(head, 100, 0);
		
		//testing popNode()
//		head=list.popNode(head);
//		list.display(head);
//		head=list.popNode(head);
//		list.display(head);
//		head=list.popNode(head);
//		list.display(head);
//		head=list.popNode(head);
//		list.display(head);
//		head=list.popNode(head);
//		list.display(head);
		
		//Testing deleteFirstNode()
//		head=list.deleteFirstNode(head);
//		head=list.deleteFirstNode(head);
//		head=list.deleteFirstNode(head);
//		head=list.deleteFirstNode(head);
//		head=list.deleteFirstNode(head);
		
//		head=list.deleteNodeAtPos(head,1);
//		list.display(head);
//		head=list.deleteNodeAtPos(head,0);
//		list.display(head);
		
		//testing reverseList()
//		head=list.reverseList(head);
		
//		int position=list.getPosition(head,5);
//		if (position==-1)
//			System.out.println("Not found");
//		else 
//			System.out.println("At position "+position);
//		position=list.getPosition(head,6);
//		if (position==-1)
//			System.out.println("data=6 : Not found");
//		else 
//			System.out.println("data=6 : At position "+position);
		
		
		//middle node
//		ListNode middleNode=list.getMiddleNode(head);
//		System.out.println("Middle Node has value "+ middleNode.data);
		
		//middle node using two references 
//		ListNode middleNode=list.getMiddleNode2(head);
//		System.out.println("Middle Node has value "+ middleNode.data);
		
		//nth node from end
//		ListNode nthnode=list.nthnodefromend(head,7);
//		if(nthnode!=null)
//			System.out.println("Nth node from end is "+ nthnode.data);
//		else
//			System.out.println("Doesnt exist");
		
		//testing remove duplicates
//		ListNode sortedhead=new ListNode(1);
//		sortedhead=list.addNode(sortedhead, 1);
//		sortedhead=list.addNode(sortedhead, 3);
//		sortedhead=list.addNode(sortedhead, 5);
//		sortedhead=list.addNode(sortedhead, 5);
//		sortedhead=list.removedup(sortedhead);
//		System.out.println("Length of list is " + list.length(sortedhead));
//		list.display(sortedhead);
//		ListNode emptyhead=null;
//		emptyhead=list.removedup(emptyhead);
//		list.display(emptyhead);
		
		head=list.removenodewithvalue(head,1);
		
		System.out.println("Length of list is " + list.length(head));
		list.display(head);
		
	}
}
