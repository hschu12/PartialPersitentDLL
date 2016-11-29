public class RunDLL {
	public static void main(String[] args) {
		PPDLL list = new PPDLL();

		list.insert(2,1);
		list.insert(7,2);
		list.insert(3,3);


		//System.out.println(list.search(1, 2));

		list.printlist();
		list.printreverse();

		list.insert(4,2);

		list.printlist();
		list.printreverse();

		list.insert(22,1);

		list.printlist();
		list.printreverse();

		System.out.println(list.search(1, 22));

		list.update(44, 2);

		list.printlist();
		list.printreverse();

	}

}