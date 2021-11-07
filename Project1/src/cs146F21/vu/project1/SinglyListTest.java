package cs146F21.vu.project1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglyListTest<T> {
	SinglyList<Integer> emptyList;
	SinglyList<Integer> singlyList;
	SinglyList<Integer> multiList;

	@Before
	public void setUp() {
		System.out.println("\nSet Up Called");
		emptyList = new SinglyList<Integer>();

		singlyList = new SinglyList<Integer>();
		singlyList.insertItem(1);

		multiList = new SinglyList<Integer>();
		multiList.insertItem(1);
		multiList.insertItem(2);
		multiList.insertItem(3);
		multiList.insertItem(80);
		System.out.println("Set Up Done");
	}

	@Test
	public void isEmptyTest() {
		//      Test emptyList is empty.
		assertTrue(emptyList.isEmpty());
//      Test singlyList is empty.
		assertFalse(singlyList.isEmpty());
		//      Test multipleList is non-empty.
		assertFalse(multiList.isEmpty());
	}

	@Test
	public void insertItemTest() {
		System.out.println("*********** InsertItemTest Called ***********");
		System.out.println("\t Test Insert Item in an emptyList");

		System.out.println("\t\tBefore insert: " + emptyList.toString());
		emptyList.insertItem(1);
		System.out.println("\t\tAfter insert: " + emptyList.toString());
		assertEquals(1, emptyList.getSize());
		assertTrue(emptyList.foundItem(1));

		System.out.println("\n\t Test Insert Item in an singlyList");
		System.out.println("\t\tBefore insert: " + singlyList.toString());
		singlyList.insertItem(2);
		System.out.println("\t\tAfter insert: " + singlyList.toString());
		assertEquals(2, singlyList.getSize());
		assertTrue(singlyList.foundItem(2));

		System.out.println("\n\t Test Insert Existed Item ");
		System.out.println("\t\tBefore insert: " + multiList.toString());
		multiList.insertItem(2);
		System.out.println("\t\tAfter insert: " + multiList.toString());
	}

	@Test
	public void removeItemTest() {
		System.out.println("*********** removeItemTest Called ***********");
		System.out.println("\tTest remove an element in emptyList.");
		System.out.println("\t\tBefore remove: " + emptyList.toString());
		assertFalse(emptyList.removeItem(1));
		System.out.println("\t\tAfter remove: " + emptyList.toString());

		System.out.println("\n\tTest remove an element in singlyList.");
		System.out.println("\t\tBefore remove: " + singlyList.toString());
		assertTrue(singlyList.removeItem(1));
		System.out.println("\t\tAfter remove: " + singlyList.toString());

		System.out.println("\n\tTest remove an element in multiList.");
		System.out.println("\t\tBefore remove: " + multiList.toString());
		assertTrue(multiList.removeItem(1));
		System.out.println("\t\tAfter remove: " + multiList.toString());

		System.out.println("\n\tTest remove an element not is not existed in multiList.");
		System.out.println("\t\tBefore remove: " + multiList.toString());
		assertFalse(multiList.removeItem(1000));
		System.out.println("\t\tAfter remove: " + multiList.toString());
	}

	@Test
	public void unionToTest() {
		System.out.println("*********** unionToTest Called ***********");
		//        Test get the union of the two list.
		SinglyList<Integer> temp = new SinglyList<Integer>();
		//        singlyList {1,10}, multiList {1,2,3} => union should contain {1,2,3}, size = 3
		singlyList.insertItem(10);
		System.out.println(
				"\t\tBefore unionTo: singlyList: " + singlyList.toString() + " multyList: " + multiList.toString());
		temp = singlyList.unionTo(multiList);
		assertTrue(temp.foundItem(1));
		assertTrue(temp.foundItem(2));
		assertTrue(temp.foundItem(3));
		System.out.println("\t\tAfter unionTo: " + temp.toString());
	}

	@Test
	public void intersectionToTest() {
		System.out.println("*********** intersectionToTest Called ***********");
		//        Test get the intersection of the two list.
		SinglyList<Integer> temp = new SinglyList<Integer>();
		//        singlyList {1}, multiList {1,2,3} => interSection should contain {1}, size = 1
		System.out.println("\t\tBefore intersectionTo: singlyList: " + singlyList.toString() + " multyList: "
				+ multiList.toString());
		temp = singlyList.intersectionTo(multiList);
		assertTrue(temp.foundItem(1));
		assertFalse(temp.foundItem(2));
		assertFalse(temp.foundItem(3));
		assertEquals(1, temp.getSize());
		System.out.println("\t\tAfter intersectionTo: " + temp.toString());
	}

}