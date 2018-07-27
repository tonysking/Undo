package com.cc.test.learn;


public class MyLinkedList implements MyList {

	private int size;
	private Node first;
	private Node last;
	
	static class Node{
		Node pre;
		Node next;
		Object data;
		
		Node() {
			
		}
		
		Node(Node pre, Object data, Node next){
			this.pre = pre;
			this.data = data;
			this.next = next;
		}
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void add(Object element) {
		Node prelast = last;
		Node addNode = new Node(prelast, element, null);
		last = addNode;
		//listΪ�� �������
		if (prelast==null) {
			first = addNode;
		}else {
			prelast.next = addNode;
		}
		
		size++;

	}

	@Override
	public Object get(int index) {
		if (index>=0 && index<size) {
			Node getNode = first;
			for (int i = 0; i < index; i++) {
				getNode = getNode.next;
			}
			return getNode.data;
		} else {
			throw new IndexOutOfBoundsException("����"+index+"Խ��");
		}
	}

	@Override
	public Object set(int index, Object element) {
		if (index>=0 && index<size) {
			Node setNode = first;
			for (int i = 0; i < index; i++) {
				setNode = setNode.next;
			}
			Node replacedNode = setNode;
			setNode.data = element;
			return replacedNode.data;
		} else {
			throw new IndexOutOfBoundsException("����"+index+"Խ��");
		}
	}

	@Override
	public Object remove(int index) {
		if (index>=0 && index<size) {
			Node removeNode = first;
			for (int i = 0; i < index; i++) {
				removeNode = removeNode.next;
			}
			//ɾ���ڵ� Ϊ ��/β�ڵ���������
			if (removeNode == first) {
				first = removeNode.next;
				//first.pre = null;
			} else if (removeNode == last) {
				last = removeNode.pre;
				//last.next = null;
			} else {
				removeNode.next.pre = removeNode.pre;
				removeNode.pre.next = removeNode.next;
			}
			
			size--;
			return removeNode.data;
		} else {
			throw new IndexOutOfBoundsException("����"+index+"Խ��");
		}
	}

	@Override
	public void clear() {
		Node clearNode = first;
		for (int i = 0; i < size; i++) {
			Node clearNext = clearNode.next;
			clearNode.pre = null;
			clearNode.data = null;
			clearNode.next = null;
			clearNode = clearNext;
		}
		
		first = last = null;
		size = 0;
	}
	
	//���list��Ԫ�ع��ɵ��ַ���
		public String toString() {
			Node outNode = first;
			String out = "[ ";
			for (int i = 0; i < size; i++) {
				out += outNode.data+" ";
				outNode = outNode.next;
			}
			out += "]";
			return out;
		}

}
