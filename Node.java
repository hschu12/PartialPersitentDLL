public class Node {

	int numberOfPointers = 2;

	int key;
	int versionNumber;
	Node[] prev;
	Node[] next;
	int[] nextVersions;
	int[] prevVersions;
	Node copy;

	public Node(int k, int v) {
		key = k;

		prev = new Node[numberOfPointers];
		prevVersions = new int [numberOfPointers];

		next = new Node[numberOfPointers];
		nextVersions = new int [numberOfPointers];

		copy = null;
		versionNumber = v;
	}

	public int getSameVersionIndex(int version) {
		for (int i = 0; i < numberOfPointers ; i++ ) {
			if(prevVersions[i] == version) {
				return i;
			}
		}
		return -1;
	}

	public int getPrevAllowedPointerIndex(int version) {
		for (int i = 0; i < numberOfPointers ; i++ ) {
			if(prevVersions[i] == version) {
				return i;
			}
			if(prevVersions[i] == 0) {
				return i;
			}
		}
		return -1; //-1 if no more excess pointers
	}

	public int getNextAllowedPointerIndex(int version) {
		for (int i = 0; i < numberOfPointers ; i++ ) {
			if(nextVersions[i] == version) {
				return i;
			}
			if(nextVersions[i] == 0) {
				return i;
			}
		}
		return -1; //-1 if no more excess pointers
	}

	public Node getNext(int version) {
		int highest = 0;
		for (int i = 0; i < numberOfPointers ; i++) {
			if ( version >= nextVersions[i] && nextVersions[i] != 0) {
				highest = i;
			}			
		}
		return next[highest];
	}

	public Node getPrev(int version) {
		int highest = 0;
		for (int i = 0; i < numberOfPointers ; i++) {
			if ( version >= prevVersions[i] && prevVersions[i] != 0) {
				highest = i;
			}			
		}
		return prev[highest];
	}


}