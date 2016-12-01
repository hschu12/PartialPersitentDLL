public class RunDLL {
	public static void main(String[] args) {
		PPDLL list = new PPDLL();

		list.insert(2,1);
		list.insert(5,2);
		list.insert(6,2);
		list.insert(42,1);


		list.nextVersion();
		list.insert(4,2);

		list.nextVersion();
		list.insert(7,3);
		list.insert(32,6);

		list.printlist();
		list.printreverse();

		System.out.println(list.search(4,3));

		System.out.println(list.search(1,2));


	}


}