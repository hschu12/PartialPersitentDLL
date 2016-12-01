import java.util.ArrayList;

public class PPDLL{

	Node first;
	int version = 1;
	int size = 0;
	ArrayList<Node> header;

	public PPDLL() {
		first = null;
		header = new ArrayList<Node>();
		header.add(first);
	}

	/*Changes to next version*/
	public void nextVersion(){
		System.out.println("new version");
		version++;
		header.add(first);
	}

	/*returns the i'th element in the v'th version*/
	public int search(int v, int i) {
		if (v > version) {
			System.out.println( "no such version. Max is: " + version);
			return -1;
		}
		Node currentNode = header.get(v-1);
		int j = 1;
		while ( currentNode.getNext(v) != null && j < i ){
			currentNode = currentNode.getNext(v);
			j++;
		}
		return currentNode.key;
	}

	/* Inserts key k at place i */
	public boolean insert(int key, int i) {
		Node currentNode = header.get(version-1);
		Node newNode = new Node(key, version);
		if (first == null) {
			first = newNode;
			int index = newNode.getNextAllowedPointerIndex(version);
			if ( index != -1) {
				newNode.nextVersions[index] = version;
				newNode.prevVersions[index] = version;
				newNode.next[index] = null;
				newNode.prev[index] = null;
			}
			header.clear();
			header.add(newNode);
			return true;
		}

		else {
			if ( i == 1 ) {
				first = newNode;
				header.set(version-1, newNode);
				newNode.next[0] = currentNode;
				newNode.nextVersions[0] = currentNode.versionNumber;
				int prevNodeIndex = newNode.next[0].getPrevAllowedPointerIndex(version); //get index of prev pointer to same version
				if (prevNodeIndex != -1) {
					newNode.next[0].prev[prevNodeIndex] = newNode;
					newNode.next[0].prevVersions[prevNodeIndex] = version;
				}
				else{
					System.out.println("copying");
					//COPY af next pga af prev pointers overload
				}
				size++;
				return true;
			}

			for (int j = 1; j < i-1; j++ ) {
				currentNode = currentNode.getNext(version);
			}
			int index = currentNode.getNextAllowedPointerIndex(version);
			if (currentNode.nextVersions[index] == version) { // is it same version?
				newNode.prev[0] = currentNode;
				newNode.prevVersions[0] = version;
				newNode.next[0] = currentNode.next[index];
				newNode.nextVersions[0] = version;
				if (currentNode.next[index] != null) {
					int prevNodeIndex = currentNode.next[index].getSameVersionIndex(version); //get index of prev pointer to same version
					newNode.next[0].prev[prevNodeIndex] = newNode;
					newNode.next[0].prevVersions[prevNodeIndex] = version;
				}
				currentNode.next[index] = newNode;
				return true;
			}		
			else {
				newNode.prev[0] = currentNode;
				newNode.prevVersions[0] = currentNode.versionNumber;
				newNode.next[0] = currentNode.next[0];
				if (currentNode.next[0] != null) {
					newNode.nextVersions[0] = currentNode.next[0].versionNumber;
					int prevNodeIndex = currentNode.next[0].getPrevAllowedPointerIndex(version); //get index of prev pointer to same version
					if (prevNodeIndex != -1) {
						newNode.next[0].prev[prevNodeIndex] = newNode;
						newNode.next[0].prevVersions[prevNodeIndex] = version;
					}
					else{
						//copying
						Node copy = new Node(newNode.next[0].key, version);
						copy.next[0] = newNode.next[0].getNext(version);
						copy.nextVersions[0] = copy.next[0].versionNumber;
						newNode.next[0] = copy;
						newNode.nextVersions[0] = version;
						copy.prev[0] = newNode;
						copy.prevVersions[0] = version;
					}
				}
				currentNode.nextVersions[index] = version;
				currentNode.next[index] = newNode;
				return true;
			}	
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
			currentNode = currentNode.getNext(version);
		}
		currentNode.key = key;
		return true;
	}


	public void printlist(){
		for (int j = 1; j <= version ; j++) {	
			System.out.println("version: " + j);
			Node current = header.get(j-1);
			while (current.getNext(j) != null) {
				System.out.print(current.key + "->");
				current = current.getNext(j);
			}
			System.out.println(current.key + "->");
		}
	}

	public void printreverse(){
		System.out.println("prev");
		for (int j = 1; j <= version ; j++) {	
			System.out.println("version: " + j);
			Node current = header.get(version-1);
			while (current.getNext(j) != null) {
					current = current.getNext(j);
				}
			while (current.getPrev(j) != null) {
					System.out.print(current.key + "->");
					current = current.getPrev(j);
				}
			System.out.println(current.key + "->");
		}
	}

}