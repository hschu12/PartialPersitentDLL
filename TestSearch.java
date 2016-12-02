public class TestSearch{
	public static void main(String[] args) {
		PPDLL list = new PPDLL();

		list.insert(1,1);
		list.insert(2,2);
		list.insert(3,3);
		list.insert(4,4);
		list.insert(5,5);
		
		list.nextVersion();

		list.insert(6,6);
		list.insert(7,7);
		list.insert(8,8);
		list.insert(9,9);
		list.insert(10,10);

	
		list.nextVersion();
		list.insert(11,1);

		list.nextVersion();
		list.insert(12,5);

		System.out.println();
		list.printlist();
		System.out.println();

		System.out.println("What is at index 5 in version 2?");
		System.out.println(list.search(2, 5));

		System.out.println("What is at index 6 in version 4?");
		System.out.println(list.search(4, 6));


		System.out.println("What is at index 1 in version 3?");
		System.out.println(list.search(3, 1));


	}
}