public class TestSimpleInsert{
	public static void main(String[] args) {
		PPDLL list = new PPDLL();

		list.insert(1,1);
		list.insert(2,2);
		list.insert(3,3);
		list.insert(4,4);
		list.insert(5,5);
		list.insert(6,6);
		list.insert(7,7);
		list.insert(8,8);
		list.insert(9,9);
		list.insert(10,10);

		list.printlist();

		System.out.println();
		System.out.println("Inserting 11 at index 1");
		list.insert(11,1);

		list.printlist();

		System.out.println();
		System.out.println("Inserting 12 at index 5");
		list.insert(12,5);

		list.printlist();

	}
}