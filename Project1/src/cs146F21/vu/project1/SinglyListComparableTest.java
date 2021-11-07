package cs146F21.vu.project1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglyListComparableTest {

	SinglyList<SongList> listOfSongList;
	SongList song1;
	SongList song2;
	SongList song3;
	SinglyList<Integer> searchSongByIdList;

	@Before
	public void setUp() {
		listOfSongList = new SinglyList<SongList>();
		song1 = new SongList(1, "Lemon Three");
		song2 = new SongList(2, "Beautiful in White");
		song3 = new SongList(3, "The Fade");
		listOfSongList.insertItem(song1);
		listOfSongList.insertItem(song2);
		listOfSongList.insertItem(song3);

		System.out.println("********** Set Up **********");
		System.out.println("Set up List of Song: \n\t" + listOfSongList);
		System.out.println("********************");
	}

	@Test
	public void foundTest() {
		searchSongByIdList = new SinglyList<Integer>();
		searchSongByIdList.insertItem(2);
		System.out.println("********** Print Out Found Test **********");
		System.out.println("\t\tSearch id: " + searchSongByIdList.toString());
		SinglyList<String> temp = SinglyListComparable.found(listOfSongList, searchSongByIdList);
		System.out.println("\t\t" + temp + "\n********************");
		// Test find a name of song by ID
		assertTrue(temp.foundItem(song2.getName()));

		System.out.println("********** Print Out Found Test With Unknow ID **********");
		// Test find a name of song by unknown ID
		searchSongByIdList = new SinglyList<Integer>();
		searchSongByIdList.insertItem(100);
		System.out.println("\t\tSearch id: " + searchSongByIdList.toString());
		temp = SinglyListComparable.found(listOfSongList, searchSongByIdList);
		System.out.println("\t\t" + temp + "\n********************");
		// assertEquals(0, temp.getSize());
	}

}
