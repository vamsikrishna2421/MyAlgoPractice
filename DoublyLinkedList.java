package main.java;

public class DoublyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length;
	
	public DoublyLinkedList() {
		this.head=null;
		this.tail=null;
		this.length=0;
	}
	
	public int length() {
		int count=0;
		ListNode temp=head;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
		length=count;
		return length;
	}
	
	public void display() {
		ListNode temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	public void addNodeAtBeg(int data) {
		ListNode newNode=new ListNode(data);
		if(head==null) {
			tail=newNode;
			head=newNode;
			return;
		}
		head.prev=newNode;
		newNode.next=head;
		head=newNode;
	}
	
	public void addNodeAtEnd(int data) {
		ListNode newNode=new ListNode(data);
		if(tail==null) {
			head=newNode;
			tail=newNode;
			return;
		}
		newNode.next=tail.next;
		tail.next=newNode;
		newNode.prev=tail;
		tail=newNode;
		return;
	}
	
	public void removeNodeAtBeg() {
		if(head==null) {
			return;
		}
		head=head.next;
		if(head!=null)
			head.prev=null;
		else {
			tail=null;
		}
	}
	
	public void removeNodeAtEnd() {
		if(tail==null) {
			return;
		}
		tail=tail.prev;
		if(tail!=null)
			tail.next=null;
		else {
			head=null;
		}
		return;
	}
	
	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode prev;
		public ListNode(int data) {
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNodeAtBeg(1);
		list.addNodeAtBeg(2);
		list.addNodeAtBeg(3);
		list.addNodeAtBeg(4);
		list.addNodeAtEnd(5);
		list.addNodeAtEnd(6);
		list.addNodeAtEnd(7);
		list.addNodeAtEnd(8);
		list.removeNodeAtBeg();
		list.removeNodeAtEnd();
		System.out.println("Length of the list is "+ list.length());
		list.display();
		
	}
}
