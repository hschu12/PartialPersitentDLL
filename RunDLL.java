import java.util.Scanner;


public class RunDLL {
	
	public static void main(String[] args){
		PPDLL list = new PPDLL();
		Scanner sc = new Scanner(System.in);

		System.out.println("Write 'I k i' to insert, where 'k' is key and 'i' is index (Ex. 'I 3 1' inserts 3 at index 1)\n" +
				"Write 'S v i' to search, where v is version and i is index (Ex. 'S 2 1' returns the value at index 1 in version 2)\n" +
				"Write 'N' to switch to a new version\n" +
				"Write 'P' to print out all versions\n" +
				"Write 'Q' to exit");
		while(true){
			String inp = sc.nextLine();

			String[] parts = inp.split(" ");
			char operation = inp.charAt(0);
			if (operation == 'Q') {
				System.exit(1);
			}
			
			switch (operation) {
				case 'I':	
							int key = Integer.parseInt(parts[1]);
							int index = Integer.parseInt(parts[2]);
							list.insert(key, index);
							System.out.println("Inserted " + key);
							break;
				case 'U': 	System.out.println("Structure does not support updates");
							break;
				case 'S': 	int version = Integer.parseInt(parts[1]);
							index = Integer.parseInt(parts[2]);
							System.out.println(list.search(version, index));
							break;
				case 'P':	System.out.println();
							list.printlist();
							System.out.println();
							break;
				case 'N':   list.nextVersion();
							break;
				default:	System.out.println("unknown operation");		
			}
		}
	}
}