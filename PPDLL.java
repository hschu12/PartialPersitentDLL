public class PPDLL{

	Node first;
	int version = 1;
	int size = 0;

	public PPDLL() {
		first = null;
	}

	/*Changes to next version*/
	public void nextVersion(){
		version++;
	}

	/*returns the i'th element in the v'th version*/
	public boolean search(int v, int i) {
		Node currentNode = first;
		while ( currentNode.next != null) {
			if ( currentNode.key == i ) {
			return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	/* Inserts key k at place i */
	public boolean insert(int key, int i) {
		System.out.println();
		System.out.println("insert " + key);

		Node currentNode = first;
		Node newNode = new Node(key);
		if ( size < i-1 ) {
			System.out.println("Cant insert at index longer than list");
			return false;
		}
		if ( first == null ) {
			System.out.println("inserts first");
			first = newNode;
			size++;
			return true;
		}
		else {
			if (i == 1) {
				System.out.println("if i = 1");
				newNode.next = currentNode;
				newNode.prev = currentNode.prev;
				currentNode.prev = newNode;
				first = newNode;
				size++;
				return true;
			}
			for (int j = 1; j < i-1 ; j++) {
				System.out.println( "moving to " + currentNode.next.key);
				currentNode = currentNode.next;
			}
			System.out.println("currentNode: " + currentNode.key);
			newNode.prev = currentNode;
			newNode.next = currentNode.next;
			if (currentNode.next != null) {
				System.out.println("Next is not null");
				newNode.next.prev = newNode;
			}
			currentNode.next = newNode;
			System.out.println("the next of current node is " + currentNode.next.key);
			size++;
			return true;
		}
	}

	/* updates the key at i to new key in the newest version*/
	public boolean update(int key, int i) {
		Node currentNode = first;
		if( i > size ) {
			System.out.println("No element at index: " + i);
			return false;
		}
		for (int j = 1; j < i ; j++) {
			currentNode = currentNode.next;
		}
		currentNode.key = key;
		return true;
	}


	public void printlist(){
		Node current = first;
		for (int i = 0 ; i < size ; i++) {
			System.out.print(current.key + "->");
			current = current.next;
		}
		System.out.println();
	}

	public void printreverse(){
		Node current = first;
		for (int i = 0 ; i < size-1 ; i++) {
			current = current.next;
		}
		for (int i = 0 ; i < size ; i++) {
			System.out.print(current.key + "->");
			current = current.prev;
		}
		System.out.println();
	}

}