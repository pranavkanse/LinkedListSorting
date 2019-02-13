import java.util.Random;

public class LinkedListImplementation 
{
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		Random rand = new Random();
		int noOfElements = 15;  //Change this to update number of elements
		
		for (int i=0;i<noOfElements;i++)
		{
			list.insertAtEnd(rand.nextInt(1000));
		}
		
		System.out.println("Before Sort: ");
		list.traverse(); //function used to traverse and print each value
		
		list.selSort(list.head); //function used to sort the linked list
		
		System.out.println("After Sort: ");
		list.traverse(); //function used to traverse and print each value
	}

}


class Node 
{
	int data;
	Node next;
}


class LinkedList 
{
	Node head;
	
	/**
	 * Function used to insert a new node at the end of linked list
	 * @param data
	 */
	public void insertAtEnd(int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head==null)
		{
			head = node;
		}
		else
		{
			Node n = this.head;
			while(n.next!=null)
			{
				n = n.next;
			}
			n.next = node;
		}
	}
	
	/**
	 * Function used to traverse through the linked list
	 */
	public void traverse()
	{
		Node node = head;
		while(node.next!=null)
		{
			System.out.print(node.data + " ");//( + node.next + "), ");
			node = node.next;
		}
		System.out.println(node.data);
	}
	
	/**
	 * Function used to sort linked list in ascending order
	 * @param tmp
	 */
	public void selSort(Node tmp)
	{
		if (tmp!=null)
		{
			while(tmp.next!=null)
			{
				Node currNode = tmp;
				Node minNode = tmp;
				Node traverseNode = tmp;
				Node nextNode = tmp.next;
				Node beforeMin = new Node();
				
				while(traverseNode.next!=null)
				{
					if(minNode.data > traverseNode.next.data)
					{
						minNode = traverseNode.next;
						beforeMin = traverseNode;
					}
					traverseNode = traverseNode.next;
				}
				
				if (currNode!=minNode)
				{
					swap(currNode,minNode,beforeMin); //function to swap nodes
					//traverse();
				}
				tmp = nextNode;
			}
		}
	}
	
	
	/**
	 * Function used to swap nodes
	 * @param currentNode
	 * @param smallestNode
	 * @param beforeSmall
	 */
	public void swap(Node currentNode, Node smallestNode, Node beforeSmall)
	{
		Node beforeCurrent = new Node();
		if (currentNode==head)
		{
			head = smallestNode;
			beforeCurrent = null;
		}
		else
		{	
			Node traverse = head;
			while(traverse.next!=null)
			{
				if (currentNode==traverse.next)
				{
					beforeCurrent = traverse;
					break;
				}
				traverse = traverse.next;
			}
		}
		
		if (beforeCurrent==null && head==smallestNode) 
		{
			if (currentNode.next!=smallestNode)
				beforeSmall.next = currentNode;
			
			Node temp = new Node();
			temp.data = currentNode.data;
			temp.next = currentNode.next;
		
			if (currentNode.next!= smallestNode)
			{
				currentNode.next = smallestNode.next;
				smallestNode.next = temp.next; 
			}
			else
			{
				currentNode.next = smallestNode.next;
				smallestNode.next = currentNode;
			}
		}
		else
		{
			beforeCurrent.next = smallestNode;
			
			if (currentNode.next!=smallestNode)
				beforeSmall.next = currentNode;
			
			Node temp = new Node();
			temp.data = currentNode.data;
			temp.next = currentNode.next;
			
			if (currentNode.next!= smallestNode)
			{
				currentNode.next = smallestNode.next;
				smallestNode.next = temp.next; 
			}
			else
			{
				currentNode.next = smallestNode.next;
				smallestNode.next = currentNode;
			}
			
		}
	}	
}


