package cs146F21.vu.project1;

/**
 * SinglyListComparable contain method found() which will return the new list
 * contain name of the song by user request
 */
public class SinglyListComparable {
	public static SinglyList<String> found(SinglyList<SongList> listOfSongList,
			SinglyList<Integer> searchSongByIdList) {
		// Create a temporary list type String.
		SinglyList<String> temp = new SinglyList<String>();

		// Get data from list of Song
		Node<SongList> currentListSong = listOfSongList.getHead();

		// Go through the list of Song, then compare Id of each Song to request ID, if
		// it matches than insert the song to temp list.
		while (currentListSong != null) {
			// Get request from user list of Song id.
			Node<Integer> requestId = searchSongByIdList.getHead();
			while (requestId != null) {
				int tempId = requestId.getData();
				if (currentListSong.getData().compareTo(tempId) == 1) {
					temp.insertItem(currentListSong.getData().getName());
					searchSongByIdList.removeItem(tempId);
					break;
				}
				requestId = requestId.getNext();
			}
			currentListSong = currentListSong.getNext();
		}
		return temp;
	}
}
